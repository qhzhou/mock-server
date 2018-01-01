package com.studentpal.parents.controller;

import com.studentpal.parents.dto.Slider;
import com.studentpal.parents.service.SliderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SliderController extends BaseController {

    @Autowired
    private SliderService sliderService;

    @RequestMapping("/sliders")
    public ResponseWrapper<List<Slider>> getSliders() {
        return ResponseWrapper.succeed(sliderService.findAll());
    }
}
