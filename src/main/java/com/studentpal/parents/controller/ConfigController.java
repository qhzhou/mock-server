package com.studentpal.parents.controller;

import com.studentpal.parents.dto.College;
import com.studentpal.parents.dto.Country;
import com.studentpal.parents.service.CollegeService;
import com.studentpal.parents.service.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConfigController extends BaseController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private CollegeService collegeService;

    @RequestMapping("/countries")
    public ResponseWrapper<List<Country>> listCountries(@RequestHeader(value = "Access-Token", required = false) String token) {
        return ResponseWrapper.succeed(countryService.findAll());
    }

    @RequestMapping("/colleges")
    public ResponseWrapper<List<College>> listColleges(@RequestHeader(value = "Access-Token", required = false) String token) {
        return ResponseWrapper.succeed(collegeService.findAll());
    }
}
