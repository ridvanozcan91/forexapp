package com.example.forexapp.service;

import com.example.forexapp.dto.ExchangeRateRequest;
import com.example.forexapp.dto.ExchangeRateResponse;
import com.example.forexapp.exception.ResourceNotFoundException;
import com.example.forexapp.integration.FixerApiClient;
import com.example.forexapp.integration.FixerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import static com.example.forexapp.util.ConversionUtil.buildExchangeRateResponse;
import static com.example.forexapp.util.ConversionUtil.calculateRate;

@Service
@RequiredArgsConstructor
public class ExchangeRateService {

    private final FixerApiClient fixerApiClient;

    @Cacheable(value = "exchangeRates", key = "#request.fromCurrency + '-' + #request.toCurrency")
    public ExchangeRateResponse getExchangeRate(ExchangeRateRequest request) {
        String symbols = request.getFromCurrency() + "," + request.getToCurrency();
        FixerResponse response = fixerApiClient.getExchangeRate(symbols);

        if (response != null && response.isSuccess() && response.getRates() != null) {
            double rate = calculateRate(request.getFromCurrency(), request.getToCurrency(), response.getRates());
            return buildExchangeRateResponse(request, rate);
        } else {
            throw new ResourceNotFoundException("Exchange rate could not be fetched");
        }
    }

}
