package com.example.forexapp.dto;

import lombok.Data;

@Data
public class ExchangeRateRequest {
    private String fromCurrency;
    private String toCurrency;
}
