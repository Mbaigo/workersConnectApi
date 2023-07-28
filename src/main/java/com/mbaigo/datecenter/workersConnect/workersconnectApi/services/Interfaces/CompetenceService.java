package com.mbaigo.datecenter.workersConnect.workersconnectApi.services.Interfaces;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Competence;

import java.util.Set;

public interface CompetenceService {
    public Competence add(Competence competence);
    public Competence update(Long id);
    public Set<Competence> getAll();
}
