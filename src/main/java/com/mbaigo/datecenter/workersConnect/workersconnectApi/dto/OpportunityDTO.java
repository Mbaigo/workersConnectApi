package com.mbaigo.datecenter.workersConnect.workersconnectApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Data @AllArgsConstructor @NoArgsConstructor
public class OpportunityDTO {
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
}
