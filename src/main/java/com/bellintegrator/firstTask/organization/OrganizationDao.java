package com.bellintegrator.firstTask.organization;

import java.util.List;

public interface OrganizationDao {
    List<Organization> filterBy(OrganizationDto organizationDto);
}
