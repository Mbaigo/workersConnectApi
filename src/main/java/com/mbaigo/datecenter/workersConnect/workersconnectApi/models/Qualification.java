package com.mbaigo.datecenter.workersConnect.workersconnectApi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.Set;

@Entity
public class Qualification {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne @JsonBackReference
    private  Opportunity opportunity;

    public Qualification() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Opportunity getOpportunity() {
        return opportunity;
    }
    public void setOpportunity(Opportunity opportunity) {
        this.opportunity = opportunity;
    }
}
