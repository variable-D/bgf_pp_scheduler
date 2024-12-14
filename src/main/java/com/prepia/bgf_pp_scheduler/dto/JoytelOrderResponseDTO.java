package com.prepia.bgf_pp_scheduler.dto;

import lombok.Data;

@Data
public class JoytelOrderResponseDTO {
    private int code;
    private String message;
    private DataDetail data;

    @Data
    public static class DataDetail {
        private String orderTid;
        private String orderCode;
    }
}
