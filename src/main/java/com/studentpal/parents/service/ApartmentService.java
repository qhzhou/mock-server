package com.studentpal.parents.service;

import com.studentpal.parents.dto.Apartment;

import org.springframework.stereotype.Service;

@Service
public class ApartmentService extends BaseService<Apartment> {
    @Override
    protected Class<Apartment> getType() {
        return Apartment.class;
    }
}
