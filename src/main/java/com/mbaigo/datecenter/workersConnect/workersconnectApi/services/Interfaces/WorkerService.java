package com.mbaigo.datecenter.workersConnect.workersconnectApi.services.Interfaces;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.CompetenceDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.WorkerDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Competence;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Worker;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface WorkerService {
    public WorkerDTO add(WorkerDTO workerDTO, Collection<Competence> competenceDTOS);
    public WorkerDTO update(Long id, WorkerDTO workerDTO);
    public Worker getById(Long id);
    public  Collection<WorkerDTO> getAll();
    public WorkerDTO getByEmail(String email);
    public Collection<WorkerDTO> getByLastdiplome(String lastediplome);
    public Collection<WorkerDTO> getByCountry(String country);
    public Collection<WorkerDTO> getByCity(String city);
    public Collection<WorkerDTO> getWorkersByCompetenceTitle(String competenceTitle);
}
