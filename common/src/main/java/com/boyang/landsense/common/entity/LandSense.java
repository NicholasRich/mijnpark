package com.boyang.landsense.common.entity;


import cn.hutool.core.annotation.Alias;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@Document
public class LandSense implements Serializable {
    @Id
    private String id;
    private String contributor;
    private Long siteId;
    private Double longSite;
    private Double latSite;
    private Long gpsAccuracy;
    private Double longActual;
    private Double latActual;
    private String skipReason;
    private Date timeSubmitted;
    private Long fotoTowardsPointCompass;
    private Long lively;
    private Long relaxing;
    private Long tranquil;
    private Long noisy;
    private Long crowded;
    private Long safe;
    private Long beauty;
    private Long biodiversity;
    private Long trees;
    private Long shrubs;
    private Long lawns;
    private Long flowers;
    private Long natveg;
    private Long benches;
    private Long play;
    private Long sports;
    private Long garbage;
    private Long veget;
    private Long paths;
    private Long facilities;
    private Long ageCats;
    private Long gender;
    private Boolean dutch;
    private Long education;
    private Long visitFreq;
    private Boolean visitDaily;
    private Boolean alone;
    private Long othParks;
    private Boolean moreInv;
    private Long nature;
    private Boolean walking;
    private Boolean jogging;
    private Boolean biking;
    @Alias("relaxing.y")
    private Boolean relaxingY;
    private Boolean socialising;
    private Boolean children;
    private String photos;
    private String geometry;
    private Double indicator;
}
