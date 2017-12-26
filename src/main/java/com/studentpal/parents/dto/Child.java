package com.studentpal.parents.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Child extends BaseObject {

    private String name;
    private String avatar;
    private String country;
    private String colleague;
    private String major;
    private BigDecimal safety;
    private BigDecimal healthy;
    private BigDecimal comfortability;
    private BigDecimal study;
    private int parent_id;
}
