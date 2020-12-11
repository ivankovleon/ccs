package com.ccs.controller;

import com.ccs.model.Exchange;
import com.ccs.repository.ExchangeRepository;
import com.ccs.service.EcbResponse;
import com.ccs.service.ExchangeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/exchange")
public class ExchangeController {

    private final ExchangeRepository exchangeRepository;
    WebClient.Builder builder = WebClient.builder();

    @Autowired
    public ExchangeController(ExchangeRepository exchangeRepository) {
        this.exchangeRepository = exchangeRepository;
    }

    @GetMapping
    public ExchangeResponse exchange(@RequestBody Exchange getExchange) {

        Exchange exchange = getExchange;

        EcbResponse ecbResponse = builder.build()
                .get()
                .uri("https://api.exchangeratesapi.io/latest?base=" + exchange.getOriginalCurrency() + "&symbols=" +
                        exchange.getTargetCurrency() + "&symbols=USD")
                .retrieve()
                .bodyToMono(EcbResponse.class)
                .block();

        exchange.setTargetAmount(ecbResponse.getRates().get(exchange.getTargetCurrency()).multiply(exchange.getOriginalAmount()));
        exchange.setDollarAmount(ecbResponse.getRates().get("USD").multiply(exchange.getOriginalAmount()));
        exchangeRepository.save(exchange);

        return new ExchangeResponse(exchange.getId(), exchange.getTargetAmount());
    }
}
