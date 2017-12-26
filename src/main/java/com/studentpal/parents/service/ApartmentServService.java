package com.studentpal.parents.service;

import com.studentpal.parents.dto.ApartmentServ;

import org.springframework.stereotype.Service;

@Service
public class ApartmentServService extends BaseService<ApartmentServ> {
    @Override
    protected Class<ApartmentServ> getType() {
        return ApartmentServ.class;
    }
}
