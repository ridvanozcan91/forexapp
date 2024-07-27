package com.example.forexapp.dto;

import lombok.Data;

@Data
public class CurrencyConversionRequest {
    private double amount;
    private String fromCurrency;
    private String toCurrency;
}
