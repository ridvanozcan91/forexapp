package com.example.forexapp.controller;

import com.example.forexapp.api.CurrencyConversionApi;
import com.example.forexapp.dto.ConversionHistoryRequest;
import com.example.forexapp.dto.ConversionHistoryResponse;
import com.example.forexapp.dto.CurrencyConversionRequest;
import com.example.forexapp.dto.CurrencyConversionResponse;
import com.example.forexapp.service.CurrencyConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CurrencyConversionController implements CurrencyConversionApi {

    private final CurrencyConversionService currencyConversionService;

    @Override
    public CurrencyConversionResponse convertCurrency(CurrencyConversionRequest request) {
        return currencyConversionService.convertCurrency(request);
    }

    @Override
    public ConversionHistoryResponse getConversionHistory(ConversionHistoryRequest request, Pageable pageable) {
        return currencyConversionService.getConversionHistory(request, pageable);
    }
}
