package com.example.forexapp.service;

import com.example.forexapp.dto.*;
import com.example.forexapp.model.CurrencyConversion;
import com.example.forexapp.repository.CurrencyConversionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.example.forexapp.util.ConversionUtil.buildConversionResponse;
import static com.example.forexapp.util.ConversionUtil.generateTranscationId;

@Service
@RequiredArgsConstructor
public class CurrencyConversionService {

    private final ExchangeRateService exchangeRateService;

    private final CurrencyConversionRepository currencyConversionRepository;

    public CurrencyConversionResponse convertCurrency(CurrencyConversionRequest request) {
        double convertedAmount = calculateConvertedAmount(request);
        String transactionId = generateTranscationId();
        persistConversion(request, convertedAmount, transactionId);
        return buildConversionResponse(convertedAmount, transactionId);
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
        return new ConversionHistoryResponse(conversions);
    }

    private void persistConversion(CurrencyConversionRequest request, double convertedAmount, String transactionId) {
        CurrencyConversion currencyConversion = new CurrencyConversion();
        currencyConversion.setFromCurrency(request.getFromCurrency());
        currencyConversion.setToCurrency(request.getToCurrency());
        currencyConversion.setAmount(request.getAmount());
        currencyConversion.setConvertedAmount(convertedAmount);
        currencyConversion.setTransactionId(transactionId);
        currencyConversionRepository.save(currencyConversion);
    }

    private double calculateConvertedAmount(CurrencyConversionRequest request) {
        ExchangeRateResponse exchangeRateResponse = exchangeRateService.getExchangeRate(
                new ExchangeRateRequest(request.getFromCurrency(), request.getToCurrency())
        );
        return request.getAmount() * exchangeRateResponse.getRate();
    }
}
