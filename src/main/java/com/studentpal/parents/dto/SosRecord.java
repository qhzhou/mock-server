package com.studentpal.parents.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SosRecord extends BaseObject {

    private BigDecimal latitude;
    private BigDecimal longitude;
    private int service_id;
    private String open_time;
    private String close_time;
}
