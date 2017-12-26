package com.studentpal.parents.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Property extends BaseObject {

    private String name;
    private String thumbnail_img;
    private String size;
    private String private_facilities;
    private String public_facilities;
    private BigDecimal price_from;
}
