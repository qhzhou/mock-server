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

import java.util.List;

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

    @RequestMapping("/children/{id}/profile")
    public ResponseWrapper<Child> profile(@RequestHeader("Access-Token") String token,
                                          @PathVariable("id") int id) {
        Child child = childService.findById(id);
        if (child == null) {
            return resourceNotFound();
        } else {
            return ResponseWrapper.succeed(child);
        }
    }

    @RequestMapping("/children/profile")
    public ResponseWrapper<List<Child>> children(@RequestHeader("Access-Token") String token) {
        User user = userService.findByToken(token);
        if (user == null) {
            throw new AuthenticationFailedException();
        } else {
            return ResponseWrapper.succeed(childService.findByParentId(user.getId()));
        }
    }

}
