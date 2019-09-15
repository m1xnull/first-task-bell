package com.bellintegrator.firstTask.organization;

import java.util.List;

public interface OrganizationService {
    List<Organization> filterBy(OrganizationDto organizationDto);
}
