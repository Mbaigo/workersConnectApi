package com.mbaigo.datecenter.workersConnect.workersconnectApi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

//class decrivant l'offre du freelancer par rapport a une offre publiée
@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Proposal {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String summary;
    private int budget;
    //Designe l'état de l'opportunité
    private State etat=State.OPEN;
    @ManyToOne
    private Worker worker;
    @ManyToOne
    private Opportunity opportunity;
}
