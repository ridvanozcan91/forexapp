package com.example.forexapp.controller;

import com.example.forexapp.dto.CurrencyConversionRequest;
import com.example.forexapp.dto.CurrencyConversionResponse;
import com.example.forexapp.service.CurrencyConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/exchange-rate")
@RequiredArgsConstructor
public class CurrencyConversionController {

    private final CurrencyConversionService currencyConversionService;

    @PostMapping("/convert")
    public ResponseEntity<CurrencyConversionResponse> convertCurrency(@RequestBody CurrencyConversionRequest request) {
        CurrencyConversionResponse response = currencyConversionService.convertCurrency(request);
        return ResponseEntity.ok(response);
    }
}
