package com.mbaigo.datecenter.workersConnect.workersconnectApi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Opportunity {
    private String title;
    private String description;
    //buget pour l'annonce
    private BigDecimal budget;
    private Date publicationDate;
    //état de la publication, ouverte ou fermée
    private boolean status;
    //le niveau requis pour postuler a ce publication, par exemple senior, junior, associate
    private String graduate;
    private String location;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "opportunity")
    private Set<Qualification> qualifications;
    @ManyToOne
    private Provider provider;
}
