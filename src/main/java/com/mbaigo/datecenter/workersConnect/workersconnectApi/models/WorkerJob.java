package com.mbaigo.datecenter.workersConnect.workersconnectApi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class WorkerJob {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String opportunityTitle;
    private int budget;
    @ManyToOne
    private Worker worker;
    @OneToOne
    private Opportunity opportunity;
}
