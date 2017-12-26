package com.studentpal.parents.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ApartmentServ extends BaseObject {

    private String name;
    private String icon_img;
    private boolean actived;

}
