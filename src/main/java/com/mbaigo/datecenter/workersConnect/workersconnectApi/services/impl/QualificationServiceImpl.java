package com.mbaigo.datecenter.workersConnect.workersconnectApi.services.impl;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.dao.QualificationRepository;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.QualificationDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Qualification;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.services.Interfaces.QualificationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class QualificationServiceImpl implements QualificationService {
    private final QualificationRepository qualificationRepository;
    private ModelMapper modelMapper;

    public QualificationServiceImpl(QualificationRepository qualificationRepository, ModelMapper modelMapper) {
        this.qualificationRepository = qualificationRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * @param qualification
     * @return
     */
    @Override
    public QualificationDTO add(Qualification qualification) {
       Qualification q= qualificationRepository.save(qualification);
        QualificationDTO qualificationDTO =modelMapper.map(q, QualificationDTO.class);
        return qualificationDTO;
    }

    /**
     * @param id 
     * @return
     */
    @Override
    public Collection<QualificationDTO> getByOpportunityId(Long id) {
        return qualificationRepository.findByOpportunity_Id(id);
    }

    /**
     * @param id
     * @return
     */
  /*  @Override
    public Collection<QualificationDTO> getByOpportunityId(Long id) {
        Collection<QualificationDTO> qualificationDTOS =qualificationRepository
                                                            .findByOpportunityId(id)
                                                                .stream().map(qualification -> modelMapper
                                                                    .map(qualification,QualificationDTO.class))
                                                                        .collect(Collectors.toList());
        return qualificationDTOS;
    }*/

    /**
     * @param id
     * @return
     */
    @Override
    public QualificationDTO getById(Long id) {
        Qualification qualification= qualificationRepository.findById(id).get();
        QualificationDTO qualificationDTO = modelMapper.map(qualification, QualificationDTO.class);
        return qualificationDTO;
    }

    /**
     * @return
     */
    @Override
    public Collection<QualificationDTO> getAll() {
        Collection<QualificationDTO> qualificationDTO = qualificationRepository
                                                            .findAll().stream()
                                                                .map(qualification -> modelMapper
                                                                        .map(qualification,QualificationDTO.class))
                                                                            .collect(Collectors.toList());
        return qualificationDTO;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public QualificationDTO update(Long id, QualificationDTO qualificationDTO) {
        Qualification qualification = qualificationRepository.findById(id).get();
        qualification.setTitle(qualificationDTO.getTitle());
        qualificationRepository.save(qualification);
        QualificationDTO qualificationDTO1 = modelMapper.map(qualification, QualificationDTO.class);
        return qualificationDTO1;
    }
}
