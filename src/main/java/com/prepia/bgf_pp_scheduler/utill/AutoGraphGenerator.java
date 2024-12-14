package com.prepia.bgf_pp_scheduler.utill;


import com.prepia.bgf_pp_scheduler.config.JoytelProperties;
import com.prepia.bgf_pp_scheduler.dto.JoytelOrderRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RequiredArgsConstructor
@Component
public class AutoGraphGenerator {

    private final JoytelProperties joytelProperties;

    public String generateAutoGraph(JoytelOrderRequestDTO requestDTO) {
        String customerCode = requestDTO.getCustomerCode();
        String customerAuth = joytelProperties.getCustomerInfo().getCustomerAuth();
        String warehouseCode = ""; // warehouse가 비어있는 경우 빈 문자열
        String type = String.valueOf(requestDTO.getType());
        String orderTid = requestDTO.getOrderTid();
        String receiveName = requestDTO.getReceiveName();
        String phone = requestDTO.getPhone();
        String timestamp = String.valueOf(requestDTO.getTimestamp());

        // itemList 처리
        StringBuilder itemListStringBuilder = new StringBuilder();
        if (requestDTO.getItemList() != null) {
            for (JoytelOrderRequestDTO.Item item : requestDTO.getItemList()) {
                itemListStringBuilder.append(item.getProductCode())
                        .append(item.getQuantity());
            }
        }

        // 결합된 원본 문자열 생성
        String originalString = customerCode + customerAuth + warehouseCode + type +
                orderTid + receiveName + phone + timestamp +
                itemListStringBuilder;

        try {
            // SHA-1 암호화 처리
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] hash = messageDigest.digest(originalString.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString(); // 최종 autoGraph 반환
        } catch (Exception e) {
            throw new RuntimeException("Error generating autoGraph", e);
        }
    }
}