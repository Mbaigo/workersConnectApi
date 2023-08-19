package com.mbaigo.datecenter.workersConnect.workersconnectApi.dto;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Opportunity;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.State;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Worker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ProposalDTO {
    private String sommary;
    private int budget;
    private State etat;
    private Opportunity opportunity;
    private Worker worker;

}
