package com.studentpal.parents.controller;

import com.studentpal.parents.dto.Apartment;
import com.studentpal.parents.dto.ApartmentServ;
import com.studentpal.parents.dto.Property;
import com.studentpal.parents.service.ApartmentServService;
import com.studentpal.parents.service.ApartmentService;
import com.studentpal.parents.service.ChildService;
import com.studentpal.parents.service.PropertyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApartmentController extends BaseController {

    @Autowired
    private ApartmentService apartmentService;

    @Autowired
    private ApartmentServService apartmentServService;

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private ChildService childService;

    @RequestMapping("/parents/apartments")
    public ResponseWrapper<List<Apartment>> getApartments(@RequestHeader(value = "Access-Token", required = false) String token,
                                                          @RequestParam(value = "child_id", required = false) int childId) {
        return ResponseWrapper.succeed(apartmentService.findAll());
    }

    @RequestMapping("/parents/apartments/property")
    public ResponseWrapper<List<Property>> getProperties(@RequestHeader(value = "Access-Token", required = false) String token,
                                                         @RequestParam(value = "child_id", required = false) int childId) {
        return ResponseWrapper.succeed(propertyService.findAll());
    }

    @RequestMapping("/parents/child/{id}/apartment_services/")
    public ResponseWrapper<List<ApartmentServ>> getApartmentServ(@RequestHeader(value = "Access-Token") String token,
                                                                 @PathVariable(value = "id") int childId,
                                                                 @RequestParam(value = "card_id", required = false, defaultValue = "0") int cardId) {

        return ResponseWrapper.succeed(apartmentServService.findAll());
    }


}
