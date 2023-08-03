package com.mbaigo.datecenter.workersConnect.workersconnectApi.services.Interfaces;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.OpportunityDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Opportunity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

public interface OpportunityService {
    public Collection<OpportunityDTO> getByQualificationTitle(String title);
    public Collection<OpportunityDTO> getByProviderEmail(String email);
    public Collection<OpportunityDTO> getByProviderTitle(String title);
    public Collection<OpportunityDTO> getByProviderId(Long providerId);
    public Collection<OpportunityDTO> findByTitle(String title);
    public Collection<OpportunityDTO> getByLocation(String location);
    public Collection<OpportunityDTO> getByStatus(boolean status);
    public Collection<OpportunityDTO> getByPublicationDate(LocalDateTime date);
    public  Opportunity add(Opportunity opportunity);
    public OpportunityDTO update(Long id,Opportunity opportunity);
    public Collection<OpportunityDTO> getAll();

}
