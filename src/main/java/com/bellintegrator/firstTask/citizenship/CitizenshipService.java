package com.bellintegrator.firstTask.citizenship;

import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface CitizenshipService {
    List<Citizenship> getAllCountries();
}
