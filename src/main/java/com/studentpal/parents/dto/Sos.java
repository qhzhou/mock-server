package com.studentpal.parents.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Sos extends BaseObject {

    private String name;
    private String aasm_state;
    private String cover_img;
    private String contact_phone;
    private String contact_name;
    private String description;
    private String website_url;
    private String routing;
    private String details;
}
