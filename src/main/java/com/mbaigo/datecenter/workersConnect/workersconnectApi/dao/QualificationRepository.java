package com.mbaigo.datecenter.workersConnect.workersconnectApi.dao;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.QualificationDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification, Long> {
    public Collection<QualificationDTO> findByOpportunity_Id(Long id);
    public Qualification findByTitle(String title);

}
