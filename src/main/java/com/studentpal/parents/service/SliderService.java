package com.studentpal.parents.service;

import com.studentpal.parents.dto.Slider;

import org.springframework.stereotype.Service;

@Service
public class SliderService extends BaseService<Slider> {
    @Override
    protected Class<Slider> getType() {
        return Slider.class;
    }
}
