package com.bellintegrator.firstTask.citizenship;

import com.bellintegrator.firstTask.DataWrapper;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/countries", produces = APPLICATION_JSON_VALUE)
public class CitizenshipController {

    @Autowired
    private CitizenshipService citizenshipService;

    @JsonView(Views.UI.class)
    @GetMapping
    public HashMap getAllCountries() {
        return DataWrapper.getData(citizenshipService.getAllCountries());
    }
}
