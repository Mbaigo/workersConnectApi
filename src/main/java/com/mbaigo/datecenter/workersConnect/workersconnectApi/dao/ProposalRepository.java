package com.mbaigo.datecenter.workersConnect.workersconnectApi.dao;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Proposal;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long> {
    public Collection<Proposal> findByWorkerId(Long id);
    public Collection<Proposal> findByOpportunity_Status(State status);
    public Collection<Proposal> findByOpportunityId(Long id);


}
