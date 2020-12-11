package com.ccs.service;

import com.ccs.repository.ExchangeRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class StatsResponse {
    private List<Long> more10000Users;
    private List<CurrencyPairs> mostUsefulPairs;

    @Autowired
    public StatsResponse(ExchangeRepository exchangeRepository) {

        this.more10000Users = exchangeRepository.getUserByDollarAmount();
        this.mostUsefulPairs = exchangeRepository.getSortedPair();
    }
}
