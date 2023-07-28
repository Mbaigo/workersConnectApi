package com.mbaigo.datecenter.workersConnect.workersconnectApi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//class decrivant l'offre du freelancer par rapport a une offre publiée
@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Proposal {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sommary;
    private String file;
    private int budget;
    private boolean etat;
    @ManyToOne
    private Worker worker;
    @ManyToOne
    private Opportunity opportunity;
}
