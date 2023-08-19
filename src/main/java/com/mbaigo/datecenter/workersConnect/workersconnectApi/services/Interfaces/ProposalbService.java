package com.mbaigo.datecenter.workersConnect.workersconnectApi.services.Interfaces;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.OpportunityDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.ProposalDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Proposal;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.State;

import java.util.Collection;

public interface ProposalbService {
    public ProposalDTO add(Proposal proposal);
    public ProposalDTO update(Long id, ProposalDTO proposalDTO);
    //Attribution de l'offre à un freelance, celui retenu par le client
    public ProposalDTO attribute(Long id, ProposalDTO proposalDTO);
    public Collection<ProposalDTO> getByWorkerId(Long id);
    public Collection<ProposalDTO> getByOpportunityStatus(State status);
    public Collection<ProposalDTO> getByOpportunityId(Long id);
}
