package com.mbaigo.datecenter.workersConnect.workersconnectApi.dao;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {
    public Collection<Opportunity> findByQualificationTitle(String title);
    public Collection<Opportunity> findByProviderEmail(String email);
    public Collection<Opportunity> findByProviderTitle(String title);

}
