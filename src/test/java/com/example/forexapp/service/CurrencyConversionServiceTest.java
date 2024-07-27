package com.example.forexapp.service;

import com.example.forexapp.dto.CurrencyConversionRequest;
import com.example.forexapp.dto.CurrencyConversionResponse;
import com.example.forexapp.dto.ExchangeRateRequest;
import com.example.forexapp.dto.ExchangeRateResponse;
import com.example.forexapp.repository.CurrencyConversionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CurrencyConversionServiceTest {

    @Mock
    private ExchangeRateService exchangeRateService;

    @Mock
    private CurrencyConversionRepository currencyConversionRepository;

    @InjectMocks
    private CurrencyConversionService currencyConversionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConvertCurrency() {
        CurrencyConversionRequest request = new CurrencyConversionRequest();
        request.setFromCurrency("USD");
        request.setToCurrency("EUR");
        request.setAmount(100);

        ExchangeRateResponse exchangeRateResponse = new ExchangeRateResponse();
        exchangeRateResponse.setRate(0.85);

        when(exchangeRateService.getExchangeRate(any(ExchangeRateRequest.class))).thenReturn(exchangeRateResponse);

        CurrencyConversionResponse response = currencyConversionService.convertCurrency(request);

        assertEquals(85.0, response.getConvertedAmount());
    }
}
