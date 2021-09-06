package com.boyang.landsense.common.vo;

import lombok.Data;

@Data
public class CountVO {
    private String siteId;
    private Double longSite;
    private Double latSite;
    private Long trueCount = 0L;
    private Long falseCount = 0L;
}
