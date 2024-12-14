package com.prepia.bgf_pp_scheduler.service.impl;

import com.prepia.bgf_pp_scheduler.config.JoytelProperties;
import com.prepia.bgf_pp_scheduler.dto.JoytelOrderRequestDTO;
import com.prepia.bgf_pp_scheduler.dto.JoytelOrderResponseDTO;
import com.prepia.bgf_pp_scheduler.service.JoytelOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class JoytelOrderServiceImpl implements JoytelOrderService {

    private final RestTemplate restTemplate;
    private final JoytelProperties joytelProperties;


    @Override
    public JoytelOrderResponseDTO placeOrder(JoytelOrderRequestDTO requestDTO) {
        String customerOrderUrl = joytelProperties.getApi().getCustomerOrder();
        return restTemplate.postForObject(customerOrderUrl, requestDTO, JoytelOrderResponseDTO.class);
    }
}
