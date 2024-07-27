package com.example.forexapp.service;

import com.example.forexapp.dto.*;
import com.example.forexapp.model.CurrencyConversion;
import com.example.forexapp.repository.CurrencyConversionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CurrencyConversionService {

    private final ExchangeRateService exchangeRateService;

    private final CurrencyConversionRepository currencyConversionRepository;

    public CurrencyConversionResponse convertCurrency(CurrencyConversionRequest request) {
        ExchangeRateRequest exchangeRateRequest = new ExchangeRateRequest();
        exchangeRateRequest.setFromCurrency(request.getFromCurrency());
        exchangeRateRequest.setToCurrency(request.getToCurrency());
        ExchangeRateResponse exchangeRateResponse = exchangeRateService.getExchangeRate(exchangeRateRequest);

        double convertedAmount = request.getAmount() * exchangeRateResponse.getRate();
        String transactionId = UUID.randomUUID().toString();

        CurrencyConversion currencyConversion = new CurrencyConversion();
        currencyConversion.setFromCurrency(request.getFromCurrency());
        currencyConversion.setToCurrency(request.getToCurrency());
        currencyConversion.setAmount(request.getAmount());
        currencyConversion.setConvertedAmount(convertedAmount);
        currencyConversion.setTransactionId(transactionId);
        currencyConversionRepository.save(currencyConversion);

        CurrencyConversionResponse response = new CurrencyConversionResponse();
        response.setConvertedAmount(convertedAmount);
        response.setTransactionId(transactionId);

        return response;
    }

    public ConversionHistoryResponse getConversionHistory(ConversionHistoryRequest request, Pageable pageable) {
        Page<CurrencyConversion> conversions;
        if (request.getTransactionId() != null && request.getTransactionDate() != null) {
            conversions = currencyConversionRepository.findByTransactionDateAndTransactionId(request.getTransactionDate(), request.getTransactionId(), pageable);
        } else if (request.getTransactionDate() != null) {
            conversions = currencyConversionRepository.findByTransactionDate(request.getTransactionDate(), pageable);
        } else {
            conversions = currencyConversionRepository.findByTransactionId(request.getTransactionId(), pageable);
        }

        ConversionHistoryResponse response = new ConversionHistoryResponse();
        response.setConversions(conversions);
        return response;
    }
}
