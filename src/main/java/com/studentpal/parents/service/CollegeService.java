package com.studentpal.parents.service;

import com.studentpal.parents.dto.College;

import org.springframework.stereotype.Service;

@Service
public class CollegeService extends BaseService<College> {
    @Override
    protected Class<College> getType() {
        return College.class;
    }
}
