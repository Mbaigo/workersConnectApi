package com.mbaigo.datecenter.workersConnect.workersconnectApi.services.Interfaces;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.CompetenceDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Competence;

import java.util.List;
import java.util.Optional;

public interface CompetenceService {
    public Competence add(Competence competence);
    public Optional<CompetenceDTO> update(Long id, CompetenceDTO competence);
    public List<Competence> getAll();
    public CompetenceDTO getById(Long id);
}
