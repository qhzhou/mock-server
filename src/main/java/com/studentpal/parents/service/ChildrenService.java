package com.studentpal.parents.service;

import com.studentpal.parents.dto.Child;

import org.springframework.stereotype.Service;

@Service
public class ChildrenService extends BaseService<Child> {

    @Override
    protected Class<Child> getType() {
        return Child.class;
    }
}
