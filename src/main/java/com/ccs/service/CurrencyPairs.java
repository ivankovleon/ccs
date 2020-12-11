package com.ccs.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyPairs {

//    String getOriginalCurrency();
//    String getTargetCurrency();
//    Integer getCount();
    private String originalCurrency;
    private String targetCurrency;
    private Integer count;

}
