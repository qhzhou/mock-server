package com.studentpal.parents.service;

import com.studentpal.parents.dto.Country;

import org.springframework.stereotype.Service;

@Service
public class CountryService extends BaseService<Country> {
    @Override
    protected Class<Country> getType() {
        return Country.class;
    }
}
