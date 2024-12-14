package com.prepia.bgf_pp_scheduler.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class JoytelProduct {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productCode;
    private Integer days;
    private boolean Sell;
    private LocalDate inputDate;
    private String lpa;
    private String smdpAddr;
    private String activationCode;
}
