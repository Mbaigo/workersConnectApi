package com.mbaigo.datecenter.workersConnect.workersconnectApi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@AllArgsConstructor @NoArgsConstructor
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
   /* @ManyToOne
    @JsonBackReference
    private Worker worker;*/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
/*
    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }*/
}
