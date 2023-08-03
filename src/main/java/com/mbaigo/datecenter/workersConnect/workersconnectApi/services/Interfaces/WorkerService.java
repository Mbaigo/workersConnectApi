package com.mbaigo.datecenter.workersConnect.workersconnectApi.services.Interfaces;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.WorkerDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Worker;

import java.util.Collection;
import java.util.Set;

public interface WorkerService {
    public WorkerDTO add(WorkerDTO worker);
    public WorkerDTO update(Long id, WorkerDTO workerDTO);
    public WorkerDTO getById(Long id);
    public  Set<WorkerDTO> getAll();
    public WorkerDTO getByEmail(String email);
    public Collection<WorkerDTO> getByCompetenceTitle(String title);
    public Set<WorkerDTO> getByLastdiplome(String lastediplome);
    public Set<WorkerDTO> getByCountry(String country);
    public Set<WorkerDTO> getByCity(String city);
    public Set<WorkerDTO> getByExperienceTitle(String experience);
}
