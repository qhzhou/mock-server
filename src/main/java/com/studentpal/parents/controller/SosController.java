package com.studentpal.parents.controller;

import com.studentpal.parents.dto.Sos;
import com.studentpal.parents.dto.SosRecord;
import com.studentpal.parents.service.ChildService;
import com.studentpal.parents.service.SosRecordService;
import com.studentpal.parents.service.SosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SosController extends BaseController {

    @Autowired
    private SosService sosService;

    @Autowired
    private ChildService childService;

    @Autowired
    private SosRecordService sosRecordService;

    @RequestMapping(value = "/parents/children/{id}/sos_services/")
    public ResponseWrapper<List<Sos>> getSosServices(@PathVariable("id") int childId) {
        if (childService.findById(childId) == null) {
            return resourceNotFound();
        }
        return ResponseWrapper.succeed(sosService.findAll());
    }

    @RequestMapping(value = "/parents/children/{id}/active_service_records/")
    public ResponseWrapper<List<SosRecord>> getSosRecords(@PathVariable("id") int childId) {
        if (childService.findById(childId) == null) {
            return resourceNotFound();
        }
        return ResponseWrapper.succeed(sosRecordService.findAll());
    }
}
