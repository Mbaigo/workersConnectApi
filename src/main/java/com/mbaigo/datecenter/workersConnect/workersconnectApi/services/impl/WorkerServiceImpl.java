package com.mbaigo.datecenter.workersConnect.workersconnectApi.services.impl;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.dao.CompetenceRepository;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.dao.ProposalRepository;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.dao.WorkerRepository;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.CompetenceDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.WorkerDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.exceptions.WorkerException;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Competence;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Worker;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.services.Interfaces.WorkerService;
import jakarta.persistence.NoResultException;
import lombok.Builder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class WorkerServiceImpl implements WorkerService {
    private final WorkerRepository workerRepository;
    private final ModelMapper modelMapper;
    private final ProposalRepository proposalRepository;
    private final CompetenceRepository competenceRepository;
    @Autowired
    public WorkerServiceImpl(WorkerRepository workerRepository, ModelMapper modelMapper, ProposalRepository proposalRepository, CompetenceRepository competenceRepository) {
        this.workerRepository = workerRepository;
        this.modelMapper = modelMapper;
        this.proposalRepository = proposalRepository;
        this.competenceRepository = competenceRepository;
    }

    /**
     * @param workerDTO
     * @return
     */
    @Override
    public WorkerDTO add(WorkerDTO workerDTO, Collection<Competence> competences) {
        Worker worker1 = modelMapper.map(workerDTO, Worker.class);
        Collection<Competence> competenceCollection =  competenceRepository.saveAll(competences);
        competenceCollection.forEach(competence -> competence.setWorker(worker1));
        worker1.setCompetences(competenceCollection);
        //competenceRepository.saveAll(competences);
        workerRepository.save(worker1);
        return workerDTO;
    }

    /**
     * @param id 
     * @param workerDTO
     * @return
     */
    @Override
    public WorkerDTO update(Long id, WorkerDTO workerDTO) {
        Worker worker = workerRepository.findById(id).get();
            if(Objects.nonNull(workerDTO.getFirstName())
                    && !"".equalsIgnoreCase(
                     workerDTO.getFirstName())){
                worker.setFirstName(workerDTO.getFirstName());
            }
        if(Objects.nonNull(workerDTO.getLastName())
                && !"".equalsIgnoreCase(
                workerDTO.getLastName())){
            worker.setLastName(workerDTO.getLastName());
        }
        if(Objects.nonNull(workerDTO.getTitle())
                && !"".equalsIgnoreCase(
                workerDTO.getTitle())){
            worker.setTitle(workerDTO.getTitle());
        }
        if(Objects.nonNull(workerDTO.getDescription())
                && !"".equalsIgnoreCase(
                workerDTO.getDescription())){
            worker.setDescription(workerDTO.getDescription());
        }
        if(Objects.nonNull(workerDTO.getEmail())
                && !"".equalsIgnoreCase(
                workerDTO.getEmail())){
            worker.setEmail(workerDTO.getEmail());
        }
        if(Objects.nonNull(workerDTO.getLastdiplome())
                && !"".equalsIgnoreCase(
                workerDTO.getLastdiplome())){
            worker.setLastdiplome(workerDTO.getLastdiplome());
        }
        if(Objects.nonNull(workerDTO.getFileDiplome())
                && !"".equalsIgnoreCase(
                workerDTO.getFileDiplome())){
            worker.setFileDiplome(workerDTO.getFileDiplome());
        }
        if(Objects.nonNull(workerDTO.getBankName())
                && !"".equalsIgnoreCase(
                workerDTO.getBankName())){
            worker.setBankName(workerDTO.getBankName());
        }
        if(Objects.nonNull(workerDTO.getBankAccountNumber())
                && !"".equalsIgnoreCase(
                workerDTO.getBankAccountNumber())){
            worker.setBankAccountNumber(workerDTO.getBankAccountNumber());
        }
        if(Objects.nonNull(workerDTO.getCountry())
                && !"".equalsIgnoreCase(
                workerDTO.getCountry())){
            worker.setCountry(workerDTO.getCountry());
        }

        if(Objects.nonNull(workerDTO.getCity())
                && !"".equalsIgnoreCase(
                workerDTO.getCity())){
            worker.setCity(workerDTO.getCity());
        }
        if(Objects.nonNull(workerDTO.getPhoneNumber())
                && !"".equalsIgnoreCase(
                workerDTO.getPhoneNumber())){
            worker.setPhoneNumber(workerDTO.getPhoneNumber());
        }
        if(Objects.nonNull(workerDTO.getPicture())
                && !"".equalsIgnoreCase(
                workerDTO.getPicture())){
            worker.setPicture(workerDTO.getPicture());
        }
        workerRepository.save(worker);
        return workerDTO;
    }

    /**
     * @param id 
     * @return
     */
    @Override
    public Worker getById(Long id) {
        return workerRepository.findById(id).get();
    }

    /**
     * @return 
     */
    @Override
    public Collection<WorkerDTO> getAll() {
        Collection<WorkerDTO> workerDTOS =  workerRepository.findAll()
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
       Worker worker = workerRepository.findByEmail(email).orElseThrow(() -> WorkerException.workerNotFoundByEmail(email));
          WorkerDTO workerDTO = modelMapper.map(worker, WorkerDTO.class);
          return workerDTO;

    }

    /**
     * @param lastediplome 
     * @return
     */
    @Override
    public Collection<WorkerDTO> getByLastdiplome(String lastediplome) {
      try {
          Collection<WorkerDTO> workerDTOS =  workerRepository
                  .findByLastdiplomeIgnoreCase(lastediplome).stream()
                  .map(worker -> modelMapper
                          .map(worker, WorkerDTO.class))
                  .collect(Collectors.toList());
          return workerDTOS;
      }catch(NoResultException ex){
          throw  WorkerException.workerNotFoundByLastdiplome(lastediplome);
      }
    }

    /**
     * @param country 
     * @return
     */
    @Override
    public Collection<WorkerDTO> getByCountry(String country) {
       try {
           Collection<WorkerDTO> workerDTOS =  workerRepository
                   .findByCountryIgnoreCase(country).stream()
                   .map(worker -> modelMapper
                           .map(worker, WorkerDTO.class))
                   .collect(Collectors.toList());
           return workerDTOS;
       } catch(NoResultException ex){
            throw  WorkerException.workerNotFoundByCountry(country);
       }
    }
    /**
     * @param city 
     * @return
     */
    @Override
    public Collection<WorkerDTO>getByCity(String city) {
         try{  Collection<WorkerDTO> workerDTOS =  workerRepository
                                                            .findByCityIgnoreCase(city).stream()
                                                                .map(worker -> modelMapper
                                                                        .map(worker,WorkerDTO.class))
                                                                            .collect(Collectors.toList());
            return workerDTOS;
         }catch(NoResultException ex){
             throw  WorkerException.workerNotFoundByCity(city);
         }
    }

    /**
     * @param competenceTitle 
     * @return
     */
    @Override
    public Collection<WorkerDTO> getWorkersByCompetenceTitle(String competenceTitle) {
       try {
           Collection<WorkerDTO> workerDTOS = workerRepository.findByCompetences_TitleIgnoreCase(competenceTitle).stream()
                   .map(worker -> modelMapper
                           .map(worker, WorkerDTO.class))
                   .collect(Collectors.toList());
           return workerDTOS;
       } catch(NoResultException ex){
           throw  WorkerException.workerNotFoundByCompetenceTitle(competenceTitle);
       }
    }

    /**
     * @param workerId
     * @return
     */

    //TODO la méthode doit retourner la liste des workers ayant en commun une experience pro
  /*  @Override
    public List<String> getWorkersWithSharedExperiences(Long workerId) {
        Worker worker = workerRepository.findById(workerId).orElse(null);
        if (worker == null) {
            // Gérer le cas où le worker n'existe pas
            return Collections.emptyList();
        }

        Set<Experience> experiences = worker.getExperiences();
        List<String> experienceTitles = experiences.stream()
                .map(Experience::getTitle)
                .collect(Collectors.toList());

        return experienceTitles;
    }*/

}