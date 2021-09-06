package com.boyang.landsense.common.dto;

import lombok.Data;

@Data
public class CountDTO {
//    private Map<String,Object> id;
    private String siteId;
    private Double longSite;
    private Double latSite;
    private Boolean status;
    private Long count;
}
