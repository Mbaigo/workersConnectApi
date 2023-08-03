package com.mbaigo.datecenter.workersConnect.workersconnectApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data @AllArgsConstructor @NoArgsConstructor
public class ExperienceDTO {
    //votre titrre dans cette experience
    private String title;
    //le nom de la boite dans laquelle l'experience s'est passee
    private String enterprise;
    private String description;
    private Date startDate;
    private Date endDate;
}
