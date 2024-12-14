package com.prepia.bgf_pp_scheduler.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "joytel")
@Data
public class JoytelProperties {

    private Api api;
    private Log log;
    private CustomerInfo customerInfo;


    @Data
    public static class Api {
        private String customerOrder;
        private String couponRedeem;
    }

    @Data
    public static class Log {
        private String file;
    }

    @Data
    public static class CustomerInfo {
        private String customerCode;
        private String customerAuth;
    }
}