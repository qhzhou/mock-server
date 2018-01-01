package com.studentpal.parents.controller;

import com.studentpal.parents.dto.Sos;
import com.studentpal.parents.dto.SosRecord;
import com.studentpal.parents.dto.SubSos;
import com.studentpal.parents.service.ChildService;
import com.studentpal.parents.service.SosRecordService;
import com.studentpal.parents.service.SosService;
import com.studentpal.parents.service.SubSosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SosController extends BaseController {

    @Autowired
    private SosService sosService;

    @Autowired
    private ChildService childService;

    @RequestMapping(value = "/sos_services")
    public ResponseWrapper<List<Sos>> getSosServices(@RequestParam(value = "child_id", defaultValue = "0") int childId) {
        return ResponseWrapper.succeed(sosService.findAll());
    }

}
