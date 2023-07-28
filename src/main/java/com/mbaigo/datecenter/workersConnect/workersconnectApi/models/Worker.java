package com.mbaigo.datecenter.workersConnect.workersconnectApi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Worker {
    private String firstName;
    private String lastName;
    private String email;
    //votre titre, exemple ingenieur en machin machin
    private String title;
    //un appercu de vous
    private String description;
    private String lastdiplome;
    private String phoneNumber;
    private String country;
    private String city;
    //heure locale
    private String localHour;
    //files
    private String fileDiplome;
    private String picture;
    private String bankAccountNumber;
    private String bankName;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @OneToMany(mappedBy = "worker")
    private Set<Experience> experiences;
    @OneToMany(mappedBy = "worker")
    private Set<Competence> competences;
    @OneToMany(mappedBy = "worker")
    private Set<Proposal> proposals;
}
