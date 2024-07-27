package com.example.forexapp.util;

import com.example.forexapp.dto.CurrencyConversionResponse;
import com.example.forexapp.dto.ExchangeRateRequest;
import com.example.forexapp.dto.ExchangeRateResponse;

import java.util.Map;
import java.util.UUID;

public class ConversionUtil {

    public static CurrencyConversionResponse buildConversionResponse(double convertedAmount, String transactionId) {
        CurrencyConversionResponse response = new CurrencyConversionResponse();
        response.setConvertedAmount(convertedAmount);
        response.setTransactionId(transactionId);
        return response;
    }

    public static String generateTranscationId() {
        return UUID.randomUUID().toString();
    }

    public static double calculateRate(String fromCurrency, String toCurrency, Map<String, Double> rates) {
        return rates.get(toCurrency) / rates.get(fromCurrency);
    }

    public static ExchangeRateResponse buildExchangeRateResponse(ExchangeRateRequest request, double rate) {
        ExchangeRateResponse exchangeRateResponse = new ExchangeRateResponse();
        exchangeRateResponse.setFromCurrency(request.getFromCurrency());
        exchangeRateResponse.setToCurrency(request.getToCurrency());
        exchangeRateResponse.setRate(rate);
        return exchangeRateResponse;
    }
}
