package com.studentpal.parents.service;

import com.studentpal.parents.dto.Child;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChildService extends BaseService<Child> {

    @Override
    protected Class<Child> getType() {
        return Child.class;
    }


    public List<Child> findByParentId(int parentId) {
        return data.stream().filter(input -> input.getParent_id() == parentId).collect(Collectors.toList());
    }
}
