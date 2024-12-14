package com.prepia.bgf_pp_scheduler.dto;

import lombok.Data;

@Data
public class JoytelProductDTO {
    private String productCode;
    private Integer days;
    private boolean Sell;
    private String inputDate; // String 형식으로 변환
    private String lpa;
    private String smdpAddr;
    private String activationCode;
}