package com.ccs.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

@Data
public class EcbResponse {

    Map<String, BigDecimal> rates;
    String currency;
    Date date;

    public EcbResponse() {
    }
}
