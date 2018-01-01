package com.studentpal.parents.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Child extends BaseObject {

    private String first_name;
    private String last_name;
    private String avatar;
    private String country;
    private String college;
    private String major;
    private String mobile;
    private String child_register_status;
    private String child_active_status;
    private int parent_id;
}
