package com.mbaigo.datecenter.workersConnect.workersconnectApi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Experience {
    //votre titrre dans cette experience
    private String title;
    //le nom de la boite dans laquelle l'experience s'est passee
    private String enterprise;
    private String description;
    private Date startDate;
    private Date endDate;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Worker worker;

}
