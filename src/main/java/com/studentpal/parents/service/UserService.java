package com.studentpal.parents.service;

import com.studentpal.parents.dto.User;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User> {

    @Override
    protected Class getType() {
        return User.class;
    }

    @Override
    public int add(User item) {
        int id = super.add(item);
        item.setToken(id + "");
        return id;
    }

    public User findByMobile(String mobile) {
        return data.stream().filter(input -> StringUtils.equals(input.getMobile(), mobile)).findFirst().orElse(null);
    }

    public User findByToken(String token) {
        return data.stream().filter(input -> StringUtils.equals(input.getToken(), token)).findFirst().orElse(null);
    }
}
