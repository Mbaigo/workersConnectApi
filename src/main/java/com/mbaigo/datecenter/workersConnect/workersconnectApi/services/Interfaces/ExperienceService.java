package com.mbaigo.datecenter.workersConnect.workersconnectApi.services.Interfaces;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Experience;

import java.util.Set;

public interface ExperienceService {
    public Experience add(Experience experience);
    public Experience update(Long id);
    public Set<Experience> getAll();
}
