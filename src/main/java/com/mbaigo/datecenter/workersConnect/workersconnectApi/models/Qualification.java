package com.mbaigo.datecenter.workersConnect.workersconnectApi.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Qualification {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToMany(mappedBy = "qualifications")
    private Set<Opportunity> opportunities;

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
}
