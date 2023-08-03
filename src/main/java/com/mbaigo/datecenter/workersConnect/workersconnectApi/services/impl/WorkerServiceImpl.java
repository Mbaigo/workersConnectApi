package com.mbaigo.datecenter.workersConnect.workersconnectApi.services.impl;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.dao.ProposalRepository;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.dao.WorkerRepository;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.WorkerDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Worker;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.services.Interfaces.WorkerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class WorkerServiceImpl implements WorkerService {
    private final WorkerRepository workerRepository;
    private ModelMapper modelMapper;
    private final ProposalRepository proposalRepository;

    public WorkerServiceImpl(WorkerRepository workerRepository, ModelMapper modelMapper, ProposalRepository proposalRepository) {
        this.workerRepository = workerRepository;
        this.modelMapper = modelMapper;
        this.proposalRepository = proposalRepository;
    }

    /**
     * @param worker 
     * @return
     */
    @Override
    public WorkerDTO add(WorkerDTO worker) {
        Worker worker1 = modelMapper.map(worker, Worker.class);
        workerRepository.save(worker1);
        return worker;
    }

    /**
     * @param id 
     * @param workerDTO
     * @return
     */
    @Override
    public WorkerDTO update(Long id, WorkerDTO workerDTO) {
        Worker worker = workerRepository.findById(id).get();
        worker.setFirstName(workerDTO.getFirstName());
        worker.setLastName(workerDTO.getLastName());
        worker.setTitle(workerDTO.getTitle());
        worker.setDescription(workerDTO.getDescription());
        worker.setEmail(workerDTO.getEmail());
        worker.setLastdiplome(workerDTO.getLastdiplome());
        worker.setFileDiplome(workerDTO.getFileDiplome());
        worker.setBankName(workerDTO.getBankName());
        worker.setBankAccountNumber(workerDTO.getBankAccountNumber());
        worker.setCountry(workerDTO.getCountry());
        worker.setCity(workerDTO.getCity());
        worker.setPhoneNumber(workerDTO.getPhoneNumber());
        worker.setPicture(workerDTO.getPicture());
        workerRepository.save(worker);
        return workerDTO;
    }

    /**
     * @param id 
     * @return
     */
    @Override
    public WorkerDTO getById(Long id) {
        Worker worker = workerRepository.findById(id).get();
        WorkerDTO workerDTO = modelMapper.map(worker, WorkerDTO.class);
        return workerDTO;
    }

    /**
     * @return 
     */
    @Override
    public Set<WorkerDTO> getAll() {
        Set<WorkerDTO> workerDTOS = (Set<WorkerDTO>) workerRepository.findAll()
                                            .stream().map(worker -> modelMapper
                                                .map(worker, WorkerDTO.class))
                                                    .collect(Collectors.toList());
        return workerDTOS;
    }

    /**
     * @param email 
     * @return
     */
    @Override
    public WorkerDTO getByEmail(String email) {
        Worker worker = workerRepository.findByEmail(email);
        WorkerDTO workerDTO = modelMapper.map(worker, WorkerDTO.class);
        return workerDTO;
    }

    /**
     * @param title 
     * @return
     */
    @Override
    public Collection<WorkerDTO> getByCompetenceTitle(String title) {
        Collection<WorkerDTO> workerDTOS= workerRepository.findByCompetenceTitle(title)
                                                    .stream().map(worker -> modelMapper
                                                        .map(worker, WorkerDTO.class))
                                                            .collect(Collectors.toList());
        return workerDTOS;
    }

    /**
     * @param lastediplome 
     * @return
     */
    @Override
    public Set<WorkerDTO> getByLastdiplome(String lastediplome) {
        Set<WorkerDTO> workerDTOS = (Set<WorkerDTO>) workerRepository
                .findByLastdiplome(lastediplome).stream()
                .map(worker -> modelMapper
                        .map(worker,WorkerDTO.class))
                .collect(Collectors.toList());
        return workerDTOS;
    }

    /**
     * @param country 
     * @return
     */
    @Override
    public Set<WorkerDTO> getByCountry(String country) {
        Set<WorkerDTO> workerDTOS = (Set<WorkerDTO>) workerRepository
                .findByCountry(country).stream()
                .map(worker -> modelMapper
                        .map(worker,WorkerDTO.class))
                .collect(Collectors.toList());
        return workerDTOS;
    }

    /**
     * @param city 
     * @return
     */
    @Override
    public Set<WorkerDTO> getByCity(String city) {
        Set<WorkerDTO> workerDTOS = (Set<WorkerDTO>) workerRepository
                                                        .findByCity(city).stream()
                                                            .map(worker -> modelMapper
                                                                    .map(worker,WorkerDTO.class))
                                                                        .collect(Collectors.toList());
        return workerDTOS;
    }

    /**
     * @param experience 
     * @return
     */
    @Override
    public Set<WorkerDTO> getByExperienceTitle(String experience) {
        return null;
    }
}
