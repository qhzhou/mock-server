package com.studentpal.parents.service;

import com.studentpal.parents.dto.Sos;

import org.springframework.stereotype.Service;

@Service
public class SosService extends BaseService<Sos> {
    @Override
    protected Class<Sos> getType() {
        return Sos.class;
    }
}
