package com.prepia.bgf_pp_scheduler.dto;

import lombok.Data;
import java.util.List;

@Data
public class JoytelOrderRequestDTO {
    private String customerCode;
    private String orderTid;
    private int type;
    private String receiveName;
    private String phone;
    private String warehouse;
    private long timestamp;
    private String autoGraph;
    private String remark;
    private List<Item> itemList;
    private String email;
    private int replyType;

    @Data
    public static class Item {
        private String productCode;
        private int quantity;
    }
}
