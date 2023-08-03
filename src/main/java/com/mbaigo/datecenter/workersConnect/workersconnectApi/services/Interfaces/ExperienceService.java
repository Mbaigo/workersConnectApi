package com.mbaigo.datecenter.workersConnect.workersconnectApi.services.Interfaces;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.ExperienceDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Experience;

import java.util.Set;

public interface ExperienceService {
    public Experience add(Experience experience);
    public ExperienceDTO update(Long id, ExperienceDTO experience);
    public Set<Experience> getAll();
}
