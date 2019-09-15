package com.bellintegrator.firstTask.organization;

import javax.validation.constraints.*;

public class OrganizationDto {

    @NotEmpty
    @NotNull
    @NotBlank
    public String name;

    @Pattern(regexp="(^$|.{9,12})")
    public String inn;

    public Boolean isActive;

    public OrganizationDto() {
    }

    public OrganizationDto(String name, String inn, Boolean isActive) {
        this.name = name;
        this.inn = inn;
        this.isActive = isActive;
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
}
