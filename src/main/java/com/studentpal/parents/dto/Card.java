package com.studentpal.parents.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Card extends BaseObject {

    @Data
    @EqualsAndHashCode(callSuper = true)
    static class Detail extends BaseObject {

    }

    private String name;
    private String cover_img;
    private int categroy_id;
    private String categroy_name;
    private String slider;
    private String caption;
    private BigDecimal price;
    private String currency;
    private boolean available;
    private boolean purchased;
}
