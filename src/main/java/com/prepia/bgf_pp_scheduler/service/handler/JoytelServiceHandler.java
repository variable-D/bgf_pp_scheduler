package com.prepia.bgf_pp_scheduler.service.handler;

import com.prepia.bgf_pp_scheduler.dto.JoytelCallbackDTO;
import com.prepia.bgf_pp_scheduler.dto.JoytelOrderRequestDTO;
import com.prepia.bgf_pp_scheduler.dto.JoytelOrderResponseDTO;
import com.prepia.bgf_pp_scheduler.service.JoytelCallbackService;
import com.prepia.bgf_pp_scheduler.service.JoytelCouponService;
import com.prepia.bgf_pp_scheduler.service.JoytelOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class JoytelServiceHandler {

    private final JoytelOrderService orderService;
    private final JoytelCallbackService callbackService;
    private final JoytelCouponService couponService;


    public void processOrder(JoytelOrderRequestDTO requestDTO) {
        JoytelOrderResponseDTO response = orderService.placeOrder(requestDTO);
        log.info("Order placed: {}", response);
    }

    public void processCallback(JoytelCallbackDTO callbackDTO) {
        callbackService.handleCallback(callbackDTO);
    }

    public void redeemCoupon(String snPin) {
        couponService.redeemCoupon(snPin);
    }
}
