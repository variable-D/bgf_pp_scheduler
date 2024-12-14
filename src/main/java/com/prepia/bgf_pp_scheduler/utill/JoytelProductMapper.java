package com.prepia.bgf_pp_scheduler.util;

import com.prepia.bgf_pp_scheduler.model.JoytelProduct;
import com.prepia.bgf_pp_scheduler.dto.JoytelProductDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class JoytelProductMapper {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static JoytelProductDTO toDTO(JoytelProduct product) {
        JoytelProductDTO dto = new JoytelProductDTO();
        dto.setProductCode(product.getProductCode());
        dto.setDays(product.getDays());
        dto.setSell(product.isSell());
        dto.setInputDate(product.getInputDate().format(FORMATTER)); // LocalDate → String 변환
        dto.setLpa(product.getLpa());
        dto.setSmdpAddr(product.getSmdpAddr());
        dto.setActivationCode(product.getActivationCode());
        return dto;
    }

    public static JoytelProduct toEntity(JoytelProductDTO dto) {
        JoytelProduct product = new JoytelProduct();
        product.setProductCode(dto.getProductCode());
        product.setDays(dto.getDays());
        product.setSell(dto.isSell());
        product.setInputDate(LocalDate.parse(dto.getInputDate(), FORMATTER)); // String → LocalDate 변환
        product.setLpa(dto.getLpa());
        product.setSmdpAddr(dto.getSmdpAddr());
        product.setActivationCode(dto.getActivationCode());
        return product;
    }
}