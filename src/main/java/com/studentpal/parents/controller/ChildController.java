package com.studentpal.parents.controller;

import com.studentpal.parents.dto.Child;
import com.studentpal.parents.exception.InvalidParamException;
import com.studentpal.parents.service.ChildrenService;
import com.studentpal.parents.util.ValidationUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
public class ChildController extends BaseController {

    @Autowired
    private ChildrenService childrenService;

    @Data
    private static class SendChildVerificationCodeRequest {
        private String mobile;
    }

    @RequestMapping("/parents/children/{id}/profile")
    public ResponseWrapper<Child> profile(@RequestHeader("Access-Token") String token,
                                          @PathVariable("id") int id) {
        Child child = childrenService.findById(id);
        if (child == null) {
            return resourceNotFound();
        } else {
            return ResponseWrapper.succeed(child);
        }
    }

    @RequestMapping(value = "/parents/send_child_verification_code", method = RequestMethod.POST)
    public ResponseWrapper<Void> sendChildVerificationCode(@RequestHeader("Access-Token") String token,
                                                           @RequestBody SendChildVerificationCodeRequest request) {
        if (!ValidationUtils.checkMobile(request.getMobile())) {
            throw new InvalidParamException("mobile");
        }
        return ResponseWrapper.succeed(null);
    }

}
