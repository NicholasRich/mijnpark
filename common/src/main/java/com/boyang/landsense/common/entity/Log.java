package com.boyang.landsense.common.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@Document
public class Log implements Serializable {
    @Id
    private String id;
    private String queryField;
    private Date queryTime;
}
