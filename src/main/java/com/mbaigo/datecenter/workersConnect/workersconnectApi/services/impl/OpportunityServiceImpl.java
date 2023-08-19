package com.mbaigo.datecenter.workersConnect.workersconnectApi.services.impl;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.dao.OpportunityRepository;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.dao.QualificationRepository;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.OpportunityDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.QualificationDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Opportunity;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Qualification;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.State;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.services.Interfaces.OpportunityService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OpportunityServiceImpl implements OpportunityService {
    private  final OpportunityRepository opportunityRepository;
    private final QualificationRepository qualificationRepository;
    private ModelMapper mapper;

    public OpportunityServiceImpl(OpportunityRepository opportunityRepository, QualificationRepository qualificationRepository, ModelMapper mapper) {
        this.opportunityRepository = opportunityRepository;
        this.qualificationRepository = qualificationRepository;
        this.mapper = mapper;
    }

    /**
     * @param title 
     * @return
     */
    @Override
    public Collection<OpportunityDTO> getByQualifications_Title(String title) {
        Collection<OpportunityDTO> opportunityDTOS =opportunityRepository
                                                        .findByQualifications_Title(title)
                                                            .stream().map(o->mapper.map(o, OpportunityDTO.class))
                                                                .collect(Collectors.toList());
        return opportunityDTOS;
    }

    /**
     * @param email 
     * @return
     */
    @Override
    public Collection<OpportunityDTO> getByProvider_Email(String email) {
        Collection<OpportunityDTO> opportunityDTOS =opportunityRepository
                                                        .findByProvider_Email(email)
                                                            .stream().map(o->mapper.map(o, OpportunityDTO.class))
                                                                .collect(Collectors.toList());
        return opportunityDTOS;
    }

    /**
     * @param title 
     * @return
     */
    @Override
    public Collection<OpportunityDTO> getByProvider_Title(String title) {
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
    public Collection<OpportunityDTO> getByProvider_Id(Long providerId) {
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
    public Collection<OpportunityDTO> getByTitle(String title) {
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
    public Collection<OpportunityDTO> getByStatus(State status) {
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
     * @param opportunityDTO
     * @return
     */
    @Override
    public Opportunity addOpportunity(OpportunityDTO opportunityDTO, List<Qualification> qualificationDTOS) {
        Opportunity opportunity = mapper.map(opportunityDTO, Opportunity.class);
        List<Qualification> qualifications =qualificationRepository.saveAll(qualificationDTOS);
        opportunity.setQualifications(qualifications);
        return opportunityRepository.save(opportunity);
    }
    /**
     * @param opportunity 
     * @return
     */
    @Override
    public OpportunityDTO updateOpportunity(Long id,Opportunity opportunity) {
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

    /**
     * @param id 
     * @return
     */
    @Override
    public Set<QualificationDTO> getQualificationsByOpportunityId(Long id) {
        Set<QualificationDTO> qualificationDTOS = (Set<QualificationDTO>) opportunityRepository
                .findQualificationsByOpportunityId(id)
                .stream().map(o->mapper.map(o, QualificationDTO.class))
                .collect(Collectors.toList());
        return qualificationDTOS;
    }
}
