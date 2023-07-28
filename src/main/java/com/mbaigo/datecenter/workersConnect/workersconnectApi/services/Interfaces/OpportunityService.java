package com.mbaigo.datecenter.workersConnect.workersconnectApi.services.Interfaces;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Opportunity;

import java.util.Collection;
import java.util.Date;

public interface OpportunityService {
    public Collection<Opportunity> getByQualificationTitle(String title);
    public Collection<Opportunity> getByProviderEmail(String email);
    public Collection<Opportunity> getByProviderTitle(String title);
    public Collection<Opportunity> getByProviderId(Long providerId);
    public Opportunity findByTitle(String title);
    public Collection<Opportunity> getByLocation(String location);
    public Collection<Opportunity> getByStatus(boolean status);
    public Collection<Opportunity> getByPublicationDate(Date date);
    public  Opportunity add(Opportunity opportunity);
    public Opportunity update(Opportunity opportunity);
    public Collection<Opportunity> getAll();

}
