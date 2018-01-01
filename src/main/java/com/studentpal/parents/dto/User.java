package com.studentpal.parents.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseObject {

    private String name;
    private String mobile;
    private String token;
    private String avatar;
}
