package com.mbaigo.datecenter.workersConnect.workersconnectApi.services.Interfaces;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.OpportunityDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.QualificationDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Opportunity;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Qualification;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.State;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface OpportunityService {
    public Collection<OpportunityDTO> getByQualifications_Title(String title);
    public Collection<OpportunityDTO> getByProvider_Email(String email);
    public Collection<OpportunityDTO> getByProvider_Title(String title);
    public Collection<OpportunityDTO> getByProvider_Id(Long providerId);
    public Collection<OpportunityDTO> getByTitle(String title);
    public Collection<OpportunityDTO> getByLocation(String location);
    public Collection<OpportunityDTO> getByStatus(State status);
    public Collection<OpportunityDTO> getByPublicationDate(LocalDateTime date);
    public  Opportunity addOpportunity(OpportunityDTO opportunity, List<Qualification> qualifications);
    public OpportunityDTO updateOpportunity(Long id,Opportunity opportunity);
    public Collection<OpportunityDTO> getAll();
    Collection<QualificationDTO>  getQualificationsByOpportunityId(Long id);

}
