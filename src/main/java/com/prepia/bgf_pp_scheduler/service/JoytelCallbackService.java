package com.prepia.bgf_pp_scheduler.service;

import com.prepia.bgf_pp_scheduler.dto.JoytelCallbackDTO;

public interface JoytelCallbackService {
    void handleCallback(JoytelCallbackDTO callbackDTO);
}
