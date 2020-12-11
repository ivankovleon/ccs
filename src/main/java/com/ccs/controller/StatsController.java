package com.ccs.controller;

import com.ccs.repository.ExchangeRepository;
import com.ccs.service.StatsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatsController {

    private final ExchangeRepository exchangeRepository;

    @Autowired
    public StatsController(ExchangeRepository exchangeRepository) {
        this.exchangeRepository = exchangeRepository;
    }

    @GetMapping
    public StatsResponse getStats() {


        return new StatsResponse(exchangeRepository);
    }
}
