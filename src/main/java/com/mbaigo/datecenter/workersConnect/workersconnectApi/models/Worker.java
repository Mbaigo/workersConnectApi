package com.mbaigo.datecenter.workersConnect.workersconnectApi.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import java.util.Collection;
import java.util.Set;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Worker {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
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

/*    @OneToMany(mappedBy = "worker")
    @JsonManagedReference
    private Collection<Experience> experiences;*/
    @OneToMany(mappedBy = "worker")
    @JsonManagedReference
    private Collection<Competence> competences;
    @OneToMany(mappedBy = "worker")
    private Collection<Proposal> proposals;
    @OneToMany(mappedBy = "worker")
    private Collection<Chat> chatCollection;
}
