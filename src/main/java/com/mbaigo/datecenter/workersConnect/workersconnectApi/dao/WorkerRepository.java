package com.mbaigo.datecenter.workersConnect.workersconnectApi.dao;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Set;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
    public Collection<Worker> findByCompetenceTitle(String title);
    public Worker findByEmail(String email);
    public Set<Worker> findByLastdiplome(String lastediplome);
    public Set<Worker> findByCountry(String country);
    public Set<Worker> findByCity(String city);
    public Set<Worker> findByExperienceTitle(String experience);

}
