package com.ccs.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "exchange")
@Entity(name = "exchange")
@Data
@NoArgsConstructor
public class Exchange {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private BigDecimal originalAmount;
    private String originalCurrency;
    private String targetCurrency;
    private BigDecimal targetAmount;
    private BigDecimal dollarAmount;

    public Exchange(Long userId, BigDecimal originalAmount, String originalCurrency, String targetCurrency){}
}
