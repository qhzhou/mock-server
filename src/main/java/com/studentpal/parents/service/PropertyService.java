package com.studentpal.parents.service;

import com.studentpal.parents.dto.Property;

import org.springframework.stereotype.Service;

@Service
public class PropertyService extends BaseService<Property> {
    @Override
    protected Class<Property> getType() {
        return Property.class;
    }
}
