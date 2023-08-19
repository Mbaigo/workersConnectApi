package com.mbaigo.datecenter.workersConnect.workersconnectApi.dao;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.WorkerDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
    public Optional<Worker> findByEmail(String email);
    public Set<Worker> findByLastdiplomeIgnoreCase(String lastediplome);
    public Set<Worker> findByCountryIgnoreCase(String country);
    public Set<Worker> findByCityIgnoreCase(String city);
    List<Worker> findByCompetences_Title(String competenceTitle);
    List<Worker> findByCompetences_TitleIgnoreCase(String competenceTitle);
}
