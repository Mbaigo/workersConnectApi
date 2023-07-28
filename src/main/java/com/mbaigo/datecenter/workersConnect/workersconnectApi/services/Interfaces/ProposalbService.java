package com.mbaigo.datecenter.workersConnect.workersconnectApi.services.Interfaces;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Proposal;

import java.util.Collection;

public interface ProposalbService {
    public Proposal add(Proposal proposal);
    public Proposal update(Long id);
    //Attribution de l'offre à un freelance, celui retenu par le client
    public Proposal attribute(Long id);
    public Collection<Proposal> findByWorkerId(Long id);
    public Collection<Proposal> findByOpportunityStatus(boolean status);
    public Collection<Proposal> findByOpportunityId(Long id);
}
