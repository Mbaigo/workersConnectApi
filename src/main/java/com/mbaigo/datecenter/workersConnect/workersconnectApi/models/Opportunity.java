package com.mbaigo.datecenter.workersConnect.workersconnectApi.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Opportunity {
    private String title;
    private String description;
    //buget pour l'annonce
    private BigDecimal budget;
    private LocalDateTime publicationDate =  LocalDateTime.now();
    //état de la publication, ouverte ou fermée
    private State status=State.OPEN;
    //le niveau requis pour postuler a ce publication, par exemple senior, junior, associate
    private String graduate;
    private String location;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "opportunity", fetch = FetchType.EAGER)
   /* @JoinTable(
            name = "opportunity_qualification",
            joinColumns = @JoinColumn(name = "opportunity_id"),
            inverseJoinColumns = @JoinColumn(name = "qualification_id"))*/
    private Collection<Qualification> qualifications;
    @ManyToOne
    private Provider provider;
    @OneToMany(mappedBy = "opportunity")
    @JsonManagedReference
    private Collection<Proposal> proposals;
    @OneToMany(mappedBy = "opportunity")
    private Collection<Chat> chatCollection;
}
