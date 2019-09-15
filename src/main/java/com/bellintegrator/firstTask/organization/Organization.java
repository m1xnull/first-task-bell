package com.bellintegrator.firstTask.organization;

import com.bellintegrator.firstTask.office.Office;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    @JsonView(OrganizationView.filter.class)
    private Long id;

    @OneToMany(mappedBy = "organization")
    private Set<Office> offices;

    @JsonView(OrganizationView.filter.class)
    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 12, nullable = false)
    private String inn;

    @JsonView(OrganizationView.filter.class)
    @Column(nullable = false)
    private Boolean isActive;

    @Column(length = 9, nullable = false)
    private String kpp;

    @Column(length = 50, nullable = false)
    private String fullName;

    @Column(length = 80, nullable = false)
    private String address;

    public Organization() {
    }

    public Organization(Set<Office> offices, String name, String inn, Boolean isActive, String kpp, String fullName, String address) {
        this.offices = offices;
        this.name = name;
        this.inn = inn;
        this.isActive = isActive;
        this.kpp = kpp;
        this.fullName = fullName;
        this.address = address;
    }

    public Organization(Long id, String name, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Office> getOffices() {
        return offices;
    }

    public void setOffices(Set<Office> offices) {
        this.offices = offices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
