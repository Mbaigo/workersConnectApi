package com.mbaigo.datecenter.workersConnect.workersconnectApi.services.impl;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.dao.OpportunityRepository;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.OpportunityDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Opportunity;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.services.Interfaces.OpportunityService;
import lombok.Builder;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OpportunityServiceImpl implements OpportunityService {
    private  final OpportunityRepository opportunityRepository;
    private ModelMapper mapper;

    public OpportunityServiceImpl(OpportunityRepository opportunityRepository, ModelMapper mapper) {
        this.opportunityRepository = opportunityRepository;
        this.mapper = mapper;
    }

    /**
     * @param title 
     * @return
     */
    @Override
    public Collection<OpportunityDTO> getByQualificationTitle(String title) {
        Collection<OpportunityDTO> opportunityDTOS =opportunityRepository
                                                        .findByQualificationTitle(title)
                                                            .stream().map(o->mapper.map(o, OpportunityDTO.class))
                                                                .collect(Collectors.toList());
        return opportunityDTOS;
    }

    /**
     * @param email 
     * @return
     */
    @Override
    public Collection<OpportunityDTO> getByProviderEmail(String email) {
        Collection<OpportunityDTO> opportunityDTOS =opportunityRepository
                                                        .findByProviderEmail(email)
                                                            .stream().map(o->mapper.map(o, OpportunityDTO.class))
                                                                .collect(Collectors.toList());
        return opportunityDTOS;
    }

    /**
     * @param title 
     * @return
     */
    @Override
    public Collection<OpportunityDTO> getByProviderTitle(String title) {
        Collection<OpportunityDTO> opportunityDTOS =opportunityRepository
                                                        .findByProviderTitle(title)
                                                            .stream().map(o->mapper.map(o, OpportunityDTO.class))
                                                                .collect(Collectors.toList());
        return opportunityDTOS;
    }

    /**
     * @param providerId 
     * @return
     */
    @Override
    public Collection<OpportunityDTO> getByProviderId(Long providerId) {
        Collection<OpportunityDTO> opportunityDTOS =opportunityRepository
                                                        .findByProviderId(providerId)
                                                            .stream().map(o->mapper.map(o, OpportunityDTO.class))
                                                                .collect(Collectors.toList());
        return opportunityDTOS;
    }

    /**
     * @param title 
     * @return
     */
    @Override
    public Collection<OpportunityDTO> findByTitle(String title) {
        Collection<OpportunityDTO> opportunityDTOS =opportunityRepository.findByTitle(title)
                .stream().map(o->mapper.map(o, OpportunityDTO.class))
                .collect(Collectors.toList());
        return opportunityDTOS;
    }

    /**
     * @param location 
     * @return
     */
    @Override
    public Collection<OpportunityDTO> getByLocation(String location) {
        Collection<OpportunityDTO> opportunityDTOS =opportunityRepository
                .findByLocation(location)
                .stream().map(o->mapper.map(o, OpportunityDTO.class))
                .collect(Collectors.toList());
        return opportunityDTOS;
    }

    /**
     * @param status 
     * @return
     */
    @Override
    public Collection<OpportunityDTO> getByStatus(boolean status) {
        Collection<OpportunityDTO> opportunityDTOS =opportunityRepository
                .findByStatus(status)
                .stream().map(o->mapper.map(o, OpportunityDTO.class))
                .collect(Collectors.toList());
        return opportunityDTOS;
    }

    /**
     * @param date 
     * @return
     */
    @Override
    public Collection<OpportunityDTO> getByPublicationDate(LocalDateTime date) {
        Collection<OpportunityDTO> opportunityDTOS =opportunityRepository
                .findByPublicationDate(date)
                .stream().map(o->mapper.map(o, OpportunityDTO.class))
                .collect(Collectors.toList());
        return opportunityDTOS;
    }

    /**
     * @param opportunity 
     * @return
     */
    @Override
    public Opportunity add(Opportunity opportunity) {
        return opportunityRepository.save(opportunity);
    }

    /**
     * @param opportunity 
     * @return
     */
    @Override
    public OpportunityDTO update(Long id,Opportunity opportunity) {
        Optional<Opportunity> op=opportunityRepository.findById(id);
        Opportunity opportunity1 = op.orElse(new Opportunity());
        opportunity1.setBudget(opportunity.getBudget());
        opportunity1.setGraduate(opportunity.getGraduate());
        opportunity1.setDescription(opportunity.getDescription());
        opportunity1.setLocation(opportunity.getLocation());
        opportunity1.setTitle(opportunity.getTitle());
        opportunity1.setQualifications(opportunity.getQualifications());
        OpportunityDTO dto = mapper.map(opportunity1, OpportunityDTO.class);
        opportunityRepository.save(opportunity1);
        return dto;
    }

    /**
     * @return 
     */
    @Override
    public Collection<OpportunityDTO> getAll() {
        Collection<OpportunityDTO> opportunityDTOS =opportunityRepository.findAll().stream()
                                                        .map(opportunity -> mapper.map(opportunity, OpportunityDTO.class))
                                                            .collect(Collectors.toList());
        return opportunityDTOS;
    }
}
