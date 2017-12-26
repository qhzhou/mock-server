package com.studentpal.parents.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SubSos extends BaseObject {

    @Data
    @EqualsAndHashCode(callSuper = true)
    static class Detail extends BaseObject {

    }

    private String name;
    private String cover_img;
    private int service_id;
    private Detail detail;
}
