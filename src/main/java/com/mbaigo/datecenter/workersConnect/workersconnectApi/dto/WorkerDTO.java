package com.mbaigo.datecenter.workersConnect.workersconnectApi.dto;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Competence;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Set;

@Data @AllArgsConstructor @NoArgsConstructor
public class WorkerDTO {
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
    private Set<Competence> competences;
}
