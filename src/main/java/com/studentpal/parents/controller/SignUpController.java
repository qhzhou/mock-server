package com.studentpal.parents.controller;

import com.studentpal.parents.dto.User;
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
public class SignUpController extends BaseController {

    @Autowired
    private UserService userService;

    @Data
    private static class SendVerificationCodeRequest {
        private String mobile;
    }

    @Data
    private static class SignUpRequest {
        private String mobile;
        private String verification_code;
        private String password;
        private String password_confirmation;

    }

    @Data
    private static class ResetPasswordRequest {
        private String mobile;
        private String verification_code;
        private String password;
        private String password_confirmation;

    }

    @Data
    private static class SignInRequest {
        private String mobile;
        private String password;
    }

    @RequestMapping(value = "/parents/send_verification_code", method = RequestMethod.POST)
    public ResponseWrapper<Void> sendVerificationCode(
            @RequestBody SendVerificationCodeRequest request) {
        if (!ValidationUtils.checkMobile(request.getMobile())) {
            throw new InvalidParamException("mobile");
        }
        return ResponseWrapper.succeed(null);
    }

    @RequestMapping(value = "/parents/sign_up", method = RequestMethod.POST)
    public ResponseWrapper<User> signUp(@RequestBody SignUpRequest request) {
        if (!ValidationUtils.checkMobile(request.getMobile())) {
            throw new InvalidParamException("mobile");
        }
        if (!StringUtils.equals(request.password, request.password_confirmation)) {
            throw new InvalidParamException("password");
        }
        if (userService.findByMobile(request.getMobile()) != null) {
            throw new InvalidParamException("mobile");
        }
        if (!StringUtils.equals(request.getVerification_code(), "123456")) {
            throw new InvalidParamException("verification code");
        }
        User user = new User();
        user.setMobile(request.getMobile());
        user.setPassword(request.getPassword());
        userService.add(user);
        return ResponseWrapper.succeed(user);
    }


    @RequestMapping(value = "/parents/reset_password", method = RequestMethod.POST)
    public ResponseWrapper<User> signUp(@RequestBody ResetPasswordRequest request) {
        if (!ValidationUtils.checkMobile(request.getMobile())) {
            throw new InvalidParamException("mobile");
        }
        if (!StringUtils.equals(request.password, request.password_confirmation)) {
            throw new InvalidParamException("password");
        }
        User byMobile = userService.findByMobile(request.getMobile());
        if (byMobile == null) {
            throw new InvalidParamException("mobile");
        }
        if (!StringUtils.equals(request.getVerification_code(), "123456")) {
            throw new InvalidParamException("verification code");
        }
        byMobile.setPassword(request.getPassword());
        return ResponseWrapper.succeed(userService.updateById(byMobile));
    }

    @RequestMapping(value = "/parents/sign_in", method = RequestMethod.POST)
    public ResponseWrapper<User> signUp(@RequestBody SignInRequest request) {
        if (!ValidationUtils.checkMobile(request.getMobile())) {
            throw new InvalidParamException("mobile");
        }
        User user = userService.findByMobile(request.getMobile());
        if (user == null) {
            return resourceNotFound();
        } else {
            if (user.getPassword().equals(request.getPassword())) {
                return ResponseWrapper.succeed(user);
            } else {
                return ResponseWrapper.error(-99, "in correct password");
            }
        }
    }

    @RequestMapping(value = "/parents/users/{id}", method = RequestMethod.GET)
    public ResponseWrapper<User> signUp(@PathVariable("id") int id) {
        User user = userService.findById(id);
        if (user == null) {
            return resourceNotFound();
        }
        return ResponseWrapper.succeed(user);
    }

    @RequestMapping(value = "/parents/send_reset_verification_code", method = RequestMethod.POST)
    public ResponseWrapper<Void> sendResetVerificationCode(@RequestBody SendVerificationCodeRequest request) {
        if (!ValidationUtils.checkMobile(request.getMobile())) {
            throw new InvalidParamException("mobile");
        }
        return ResponseWrapper.succeed(null);
    }

    @RequestMapping(value = "/parents/profile")
    public ResponseWrapper<User> profile(@RequestHeader("Access-Token") String token) {
        User user = userService.findByToken(token);
        if (user == null) {
            return resourceNotFound();
        } else {
            return ResponseWrapper.succeed(user);
        }
    }
}
