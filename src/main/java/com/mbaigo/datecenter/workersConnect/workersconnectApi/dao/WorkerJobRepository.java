package com.mbaigo.datecenter.workersConnect.workersconnectApi.dao;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.WorkerJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface WorkerJobRepository extends JpaRepository<WorkerJob, Long> {
    public Collection<WorkerJob> findByWorkerId(Long id);
}
