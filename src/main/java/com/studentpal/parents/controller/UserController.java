package com.studentpal.parents.controller;

import com.studentpal.parents.dto.User;
import com.studentpal.parents.exception.AuthenticationFailedException;
import com.studentpal.parents.exception.InvalidParamException;
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
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Data
    private static class SendVerificationCodeRequest {
        private String mobile;
    }

    @Data
    private static class SignInRequest {
        private String mobile;
        private String verification_code;
    }

    @Data
    private static class UpdateMobileRequest {
        private String mobile;
    }

    @RequestMapping(value = "/send_verification_code", method = RequestMethod.POST)
    public ResponseWrapper<Void> sendVerificationCode(
            @RequestBody SendVerificationCodeRequest request) {
        if (!ValidationUtils.checkMobile(request.getMobile())) {
            throw new InvalidParamException("mobile");
        }
        return ResponseWrapper.succeed(null);
    }

    @RequestMapping(value = "/verify_mobile", method = RequestMethod.POST)
    public ResponseWrapper<User> signUp(@RequestBody SignInRequest request) {
        if (!ValidationUtils.checkMobile(request.getMobile())) {
            throw new InvalidParamException("mobile");
        }
        if (!StringUtils.equals(request.getVerification_code(), "123456")) {
            throw new InvalidParamException("verification code");
        }
        User user = userService.findByMobile(request.getMobile());
        if (user == null) {
            user = new User();
            user.setMobile(request.getMobile());
            userService.add(user);
            return ResponseWrapper.succeed(user);
        } else {
            return ResponseWrapper.succeed(user);
        }
    }

    @RequestMapping(value = "/profile")
    public ResponseWrapper<User> profile(@RequestHeader(value = "Access-Token", required = false) String token) {
        User user = userService.findByToken(token);
        if (user == null) {
            throw new AuthenticationFailedException();
        } else {
            return ResponseWrapper.succeed(user);
        }
    }

    @RequestMapping(value = "/update_mobile")
    public ResponseWrapper<User> updateMobile(@RequestHeader(value = "Access-Token", required = false) String token,
                                              @RequestBody UpdateMobileRequest request) {
        User user = userService.findByToken(token);
        if (user == null) {
            throw new AuthenticationFailedException();
        }
        user.setMobile(request.getMobile());
        userService.updateById(user);
        return ResponseWrapper.succeed(user);

    }
}
