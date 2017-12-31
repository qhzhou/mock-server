package com.studentpal.parents.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Country extends BaseObject {

    private String name;
}
