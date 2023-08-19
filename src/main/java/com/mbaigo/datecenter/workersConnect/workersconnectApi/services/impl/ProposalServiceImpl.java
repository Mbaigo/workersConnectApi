package com.mbaigo.datecenter.workersConnect.workersconnectApi.services.impl;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.dao.ProposalRepository;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.ProposalDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Proposal;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.State;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.services.Interfaces.ProposalbService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ProposalServiceImpl implements ProposalbService {
    private  final ProposalRepository proposalRepository;
    private ModelMapper modelMapper;

    public ProposalServiceImpl(ProposalRepository proposalRepository, ModelMapper modelMapper) {
        this.proposalRepository = proposalRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * @param proposal 
     * @return
     */
    @Override
    public ProposalDTO add(Proposal proposal) {
        Proposal p= proposalRepository.save(proposal);
        ProposalDTO proposalDTO = modelMapper.map(p,ProposalDTO.class);
        return proposalDTO;
    }

    /**
     * @param id
     * @param proposalDTO
     * @return
     */
    @Override
    public ProposalDTO update(Long id, ProposalDTO proposalDTO) {
        Proposal p = proposalRepository.findById(id).get();
        p.setSummary(proposalDTO.getSommary());
        p.setBudget(proposalDTO.getBudget());
        p.setOpportunity(proposalDTO.getOpportunity());
        proposalRepository.save(p);
        ProposalDTO dto = modelMapper.map(p, ProposalDTO.class);
        return dto;
    }

    /**
     * @param id 
     * @return
     */
    @Override
    public ProposalDTO attribute(Long id, ProposalDTO proposalDTO) {
        Proposal p = proposalRepository.findById(id).get();
        p.setWorker(proposalDTO.getWorker());
        proposalRepository.save(p);
        ProposalDTO proposalDTO1 = modelMapper.map(p, ProposalDTO.class);
        return proposalDTO1;
    }

    /**
     * @param id 
     * @return
     */
    @Override
    public Collection<ProposalDTO> getByWorkerId(Long id) {
        Collection<ProposalDTO> proposals=proposalRepository.findByWorkerId(id)
                                                            .stream()
                                                                .map(p-> modelMapper.map(p,ProposalDTO.class))
                                                                    .collect(Collectors.toList());
        return proposals;
    }

    /**
     * @param status 
     * @return
     */
    @Override
    public Collection<ProposalDTO> getByOpportunityStatus(State status) {
        Collection<ProposalDTO> proposalDTOS = proposalRepository
                                                    .findByOpportunity_Status(status)
                                                        .stream()
                                                            .map(props->modelMapper.map(props,ProposalDTO.class))
                                                                .collect(Collectors.toList());
        return proposalDTOS;
    }

    /**
     * @param id 
     * @return
     */
    @Override
    public Collection<ProposalDTO> getByOpportunityId(Long id) {
        Collection<ProposalDTO> proposalDTOS = proposalRepository
                                                    .findByOpportunityId(id)
                                                        .stream()
                                                            .map(props->modelMapper.map(props,ProposalDTO.class))
                                                                .collect(Collectors.toList());
        return proposalDTOS;
    }
}
