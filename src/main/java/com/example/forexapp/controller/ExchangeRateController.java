package com.example.forexapp.controller;

import com.example.forexapp.api.ExchangeRatesApi;
import com.example.forexapp.dto.ExchangeRateRequest;
import com.example.forexapp.dto.ExchangeRateResponse;
import com.example.forexapp.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExchangeRateController implements ExchangeRatesApi {

    private final ExchangeRateService exchangeRateService;

    @Override
    public ExchangeRateResponse getExchangeRate(String fromCurrency, String toCurrency) {
        ExchangeRateRequest request = new ExchangeRateRequest(fromCurrency, toCurrency);
        return exchangeRateService.getExchangeRate(request);
    }
}
