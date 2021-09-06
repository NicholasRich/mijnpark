package com.boyang.landsense.common.vo;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

@Data
public class AvgVO {
    @Alias("id")
    private String id;
    private Double longSite;
    private Double latSite;
    private Double avg;

}
