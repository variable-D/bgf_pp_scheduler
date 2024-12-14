package com.prepia.bgf_pp_scheduler.service.impl;

import com.prepia.bgf_pp_scheduler.config.JoytelProperties;
import com.prepia.bgf_pp_scheduler.service.JoytelCouponService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class JoytelCouponServiceImpl implements JoytelCouponService {

    private final RestTemplate restTemplate;
    private final JoytelProperties joytelProperties;


    @Override
    public void redeemCoupon(String snPin) {
        String redeemUrl = joytelProperties.getApi().getCouponRedeem();
        Map<String, Object> request = Map.of("coupon", snPin, "qrcodeType", 1);
        ResponseEntity<String> response = restTemplate.postForEntity(redeemUrl, request, String.class);
        log.info("Coupon redeemed: {}", response.getBody());
    }
}