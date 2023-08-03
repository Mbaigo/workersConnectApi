package com.mbaigo.datecenter.workersConnect.workersconnectApi.services.Interfaces;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.QualificationDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Qualification;

import java.util.Collection;

public interface QualificationService {
    public QualificationDTO add(Qualification qualification);
    public Collection<QualificationDTO> getByOpportunityId(Long id);
    public QualificationDTO getById(Long id);
    public Collection<QualificationDTO> getAll();
    public QualificationDTO update(Long id,QualificationDTO qualificationDTO);
}
