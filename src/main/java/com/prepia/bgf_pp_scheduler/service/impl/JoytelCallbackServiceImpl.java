package com.prepia.bgf_pp_scheduler.service.impl;

import com.prepia.bgf_pp_scheduler.dto.JoytelCallbackDTO;
import com.prepia.bgf_pp_scheduler.service.JoytelCallbackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JoytelCallbackServiceImpl implements JoytelCallbackService {



    @Override
    public void handleCallback(JoytelCallbackDTO callbackDTO) {
        log.info("Callback received: {}", callbackDTO);

    }
}