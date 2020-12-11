package com.ccs.service;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Data
@Service
public class ExchangeResponse {

    private Long id;
    private  BigDecimal targetAmount;


    public ExchangeResponse() {
    }

    public ExchangeResponse(Long id, BigDecimal targetAmount) {
        this.id = id;
        this.targetAmount = targetAmount;
    }
}
