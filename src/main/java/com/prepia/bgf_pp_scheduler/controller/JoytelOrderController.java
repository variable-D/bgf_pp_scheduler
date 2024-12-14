package com.prepia.bgf_pp_scheduler.controller;

import com.prepia.bgf_pp_scheduler.dto.JoytelCallbackDTO;
import com.prepia.bgf_pp_scheduler.dto.JoytelOrderRequestDTO;
import com.prepia.bgf_pp_scheduler.service.handler.JoytelServiceHandler;
import com.prepia.bgf_pp_scheduler.utill.AutoGraphGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mallapi/extern/joytel")
public class JoytelOrderController {

    private final JoytelServiceHandler joytelServiceHandler;
    private final AutoGraphGenerator autoGraphGenerator;

    @GetMapping("/order")
    public ResponseEntity<String> testOrder() {
        JoytelOrderRequestDTO requestDTO = new JoytelOrderRequestDTO();
        Random random = new Random();

        // 요청 데이터 설정
        requestDTO.setCustomerCode("10391");
        requestDTO.setOrderTid(requestDTO.getCustomerCode() + System.currentTimeMillis() + random.nextInt(100000));
        requestDTO.setType(3);
        requestDTO.setWarehouse("");
        requestDTO.setReceiveName("prepiatest");
        requestDTO.setPhone("025798863");
        requestDTO.setTimestamp(System.currentTimeMillis());
        requestDTO.setEmail("cs@prepia.co.kr");
        requestDTO.setReplyType(1);
        requestDTO.setRemark("test-order");

        // Item 설정
        JoytelOrderRequestDTO.Item item = new JoytelOrderRequestDTO.Item();
        item.setProductCode("eSIM-test");
        item.setQuantity(1);
        requestDTO.setItemList(List.of(item)); // itemList에 추가

        // autoGraph 설정
        String autoGraph = autoGraphGenerator.generateAutoGraph(requestDTO);
        requestDTO.setAutoGraph(autoGraph); // 생성된 autoGraph를 DTO에 설정

        // 서비스 호출
        joytelServiceHandler.processOrder(requestDTO);

        return ResponseEntity.ok("Order placed successfully");
    }

    @PostMapping("/ordersn")
    public ResponseEntity<Void> handleCallback(@RequestBody JoytelCallbackDTO callbackDTO) {
        // 콜백 데이터 처리
        joytelServiceHandler.processCallback(callbackDTO);

        return ResponseEntity.ok().build();
    }
}
