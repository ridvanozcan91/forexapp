package com.example.forexapp.controller;

import com.example.forexapp.dto.ExchangeRateRequest;
import com.example.forexapp.dto.ExchangeRateResponse;
import com.example.forexapp.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/exchange-rate")
@RequiredArgsConstructor
@Validated
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    @GetMapping
    public ResponseEntity<ExchangeRateResponse> getExchangeRate(
            @RequestParam @NonNull String fromCurrency,
            @RequestParam @NonNull String toCurrency) {
        ExchangeRateRequest request = new ExchangeRateRequest();
        request.setFromCurrency(fromCurrency);
        request.setToCurrency(toCurrency);
        ExchangeRateResponse response = exchangeRateService.getExchangeRate(request);
        return ResponseEntity.ok(response);
    }
}
