package com.mbaigo.datecenter.workersConnect.workersconnectApi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
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
    private String lastDiplome;
    private String country;
    //heure locale
    private String localHour;
    private String city;
    private String picture;
    private String phoneNumber;
    private String bankAccountNumber;
    private String bankName;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @OneToMany(mappedBy = "worker")
    private Set<Experience> experiences;
    @OneToMany(mappedBy = "worker")
    private Set<Competence> competences;
    @OneToMany(mappedBy = "worker")
    private Set<WorkerJob> workerJobs;
}
