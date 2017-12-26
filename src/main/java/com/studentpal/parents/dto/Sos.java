package com.studentpal.parents.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Sos extends BaseObject {

    private String name;
    private boolean actived;
    private String icon_img;
    private String call_customer_service;
    private String description;
    private String call_us;
}
