package com.prepia.bgf_pp_scheduler.dto;

import lombok.Data;

import java.util.List;

@Data
public class JoytelCallbackDTO {
    private String orderCode;
    private String orderTid;
    private String phone;
    private String receiveName;
    private String email;
    private int status;
    private List<Item> itemList;

    @Data
    public static class Item {
        private String productCode;
        private int quantity;
        private List<SerialNumber> snList;

        @Data
        public static class SerialNumber {
            private String snCode;
            private String snPin;
            private String productExpireDate;
        }
    }
}