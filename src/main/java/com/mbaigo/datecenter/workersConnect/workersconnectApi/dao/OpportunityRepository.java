package com.mbaigo.datecenter.workersConnect.workersconnectApi.dao;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {
    public Collection<Opportunity> findByQualificationTitle(String title);
    public Collection<Opportunity> findByProviderEmail(String email);
    public Collection<Opportunity> findByProviderTitle(String title);
    public Collection<Opportunity> findByProviderId(Long providerId);
    public Opportunity findByTitle(String title);
    public Collection<Opportunity> findByLocation(String location);
    public Collection<Opportunity> findByPublicationDate(Date date);
    public Collection<Opportunity> findByStatus(boolean status);

}
