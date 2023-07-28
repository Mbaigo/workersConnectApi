package com.mbaigo.datecenter.workersConnect.workersconnectApi.services.Interfaces;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Qualification;

import java.util.Collection;

public interface QualificationService {
    public Qualification add(Qualification qualification);
    public Collection<Qualification> getByOpportunityId(Long id);
    public Qualification getById(Long id);
    public Collection<Qualification> getAll();
    public Qualification update(Long id);
}
