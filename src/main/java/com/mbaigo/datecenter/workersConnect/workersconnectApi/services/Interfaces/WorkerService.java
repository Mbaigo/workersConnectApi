package com.mbaigo.datecenter.workersConnect.workersconnectApi.services.Interfaces;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Worker;

import java.util.Collection;
import java.util.Set;

public interface WorkerService {
    public Worker add(Worker worker);
    public Worker update(Long id);
    public Worker getById(Long id);
    public  Set<Worker> getAll();
    public Worker getByEmail(String email);
    public Collection<Worker> getByCompetenceTitle(String title);
    public Set<Worker> getByLastdiplome(String lastediplome);
    public Set<Worker> getByCountry(String country);
    public Set<Worker> getByCity(String city);
    public Set<Worker> getByExperienceTitle(String experience);
}
