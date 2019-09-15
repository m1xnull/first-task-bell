package com.bellintegrator.firstTask.citizenship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenshipServiceImpl implements CitizenshipService {

    @Autowired
    private  CitizenshipDao citizenshipDao;

    @Override
    public List<Citizenship> getAllCountries() {
        return citizenshipDao.findAll();
    }
}
