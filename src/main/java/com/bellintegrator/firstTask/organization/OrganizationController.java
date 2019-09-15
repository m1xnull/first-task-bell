package com.bellintegrator.firstTask.organization;

import com.bellintegrator.firstTask.DataDto;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {

    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping("/list")
    @JsonView(OrganizationView.filter.class)
    public HashMap list(@RequestBody @Valid OrganizationDto organizationDto) {
        return DataDto.getData(organizationService.filterBy(organizationDto));
    }
}
