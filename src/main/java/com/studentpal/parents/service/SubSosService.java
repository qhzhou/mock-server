package com.studentpal.parents.service;

import com.studentpal.parents.dto.SubSos;

import org.springframework.stereotype.Service;

@Service
public class SubSosService extends BaseService<SubSos> {
    @Override
    protected Class<SubSos> getType() {
        return SubSos.class;
    }
}
