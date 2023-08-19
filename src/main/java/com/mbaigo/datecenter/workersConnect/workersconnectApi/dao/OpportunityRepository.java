package com.mbaigo.datecenter.workersConnect.workersconnectApi.dao;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Opportunity;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Qualification;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {
    public Collection<Opportunity> findByQualifications_Title(String QualificationTitle);
    public Collection<Opportunity> findByProvider_Email(String email);
    public Collection<Opportunity> findByProviderTitle(String title);
    public Collection<Opportunity> findByProviderId(Long providerId);
    public Collection<Opportunity> findByTitle(String title);
    public Collection<Opportunity> findByLocation(String location);
    public Collection<Opportunity> findByPublicationDate(LocalDateTime date);
    public Collection<Opportunity> findByStatus(State status);
    @Query("SELECT o.qualifications FROM Opportunity o WHERE o.id = :opportunityId")
    Set<Qualification> findQualificationsByOpportunityId(@Param("opportunityId") Long opportunityId);


}
