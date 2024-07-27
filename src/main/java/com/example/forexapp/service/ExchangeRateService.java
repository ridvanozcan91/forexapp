package com.example.forexapp.service;

import com.example.forexapp.dto.ExchangeRateRequest;
import com.example.forexapp.dto.ExchangeRateResponse;
import com.example.forexapp.exception.ResourceNotFoundException;
import com.example.forexapp.integration.FixerApiClient;
import com.example.forexapp.integration.FixerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExchangeRateService {

    private final FixerApiClient fixerApiClient;

    public ExchangeRateResponse getExchangeRate(ExchangeRateRequest request) {
        String symbols = request.getFromCurrency() + "," + request.getToCurrency();
        FixerResponse response = fixerApiClient.getExchangeRate(symbols);

        if (response != null && response.isSuccess() && response.getRates() != null) {
            double rate = response.getRates().get(request.getToCurrency()) / response.getRates().get(request.getFromCurrency());
            ExchangeRateResponse exchangeRateResponse = new ExchangeRateResponse();
            exchangeRateResponse.setFromCurrency(request.getFromCurrency());
            exchangeRateResponse.setToCurrency(request.getToCurrency());
            exchangeRateResponse.setRate(rate);
            return exchangeRateResponse;
        } else {
            throw new ResourceNotFoundException("Exchange rate could not be fetched");
        }
    }
}
