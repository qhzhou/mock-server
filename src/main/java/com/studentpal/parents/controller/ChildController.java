package com.studentpal.parents.controller;

import com.studentpal.parents.dto.Child;
import com.studentpal.parents.dto.User;
import com.studentpal.parents.exception.AuthenticationFailedException;
import com.studentpal.parents.exception.InvalidParamException;
import com.studentpal.parents.service.ChildService;
import com.studentpal.parents.service.UserService;
import com.studentpal.parents.util.ValidationUtils;

import org.apache.commons.lang3.StringUtils;
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
    private ChildService childService;

    @Autowired
    private UserService userService;

    @Data
    private static class SendChildVerificationCodeRequest {
        private String mobile;
    }

    @Data
    private static class VerifyChildMobileRequest {
        private String mobile;
        private String verification_code;
    }

    @Data
    private static class ChildInfoRequest {
        private String name;
        private String colleague;
        private String city;
        private String country;
    }

    @RequestMapping("/parents/children/{id}/profile")
    public ResponseWrapper<Child> profile(@RequestHeader("Access-Token") String token,
                                          @PathVariable("id") int id) {
        Child child = childService.findById(id);
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

    @RequestMapping(value = "/parents/verify_child_mobile", method = RequestMethod.POST)
    public ResponseWrapper<Void> verifyChildMobile(@RequestHeader("Access-Token") String token,
                                                   @RequestBody VerifyChildMobileRequest request) {
        if (!ValidationUtils.checkMobile(request.mobile)) {
            throw new InvalidParamException("mobile");
        }
        if (!StringUtils.equals("123456", request.verification_code)) {
            throw new InvalidParamException("verification code");
        }
        return ResponseWrapper.succeed(null);
    }

    @RequestMapping(value = "/parents/submit_child_info", method = RequestMethod.POST)
    public ResponseWrapper<Child> submitChildInfo(@RequestHeader("Access-Token") String token,
                                                  @RequestBody ChildInfoRequest request) {
        User user = userService.findByToken(token);
        if (user == null) {
            throw new AuthenticationFailedException();
        }
        Child child = new Child();
        child.setCountry(request.getCountry());
        child.setName(request.getName());
        child.setColleague(request.getColleague());
        child.setParent_id(user.getId());
        childService.add(child);
        return ResponseWrapper.succeed(child);

    }
}
