package com.bellintegrator.firstTask.office;

import com.bellintegrator.firstTask.organization.Organization;

import javax.persistence.*;

@Entity
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Version
    private Integer version;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 80, nullable = false)
    private String address;

    @Column(nullable = false)
    private Boolean isActive;

    @Column(length = 12, nullable = false)
    private String phone;

    public Office() {
    }

    public Office(Organization organization, String name, String address, Boolean isActive, String phone) {
        this.organization = organization;
        this.name = name;
        this.address = address;
        this.isActive = isActive;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
