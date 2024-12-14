package com.prepia.bgf_pp_scheduler.service;

import com.prepia.bgf_pp_scheduler.dto.JoytelOrderRequestDTO;
import com.prepia.bgf_pp_scheduler.dto.JoytelOrderResponseDTO;

public interface JoytelOrderService {
    JoytelOrderResponseDTO placeOrder(JoytelOrderRequestDTO requestDTO);

}