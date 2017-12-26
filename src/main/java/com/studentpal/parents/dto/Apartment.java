package com.studentpal.parents.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Apartment extends BaseObject {

    private String cover_img;
    private String title;
    private String address;
    private String type;
    private String colleague;
    private String description;
    private boolean slider;
    private BigDecimal price;
    private int property_id;


}
