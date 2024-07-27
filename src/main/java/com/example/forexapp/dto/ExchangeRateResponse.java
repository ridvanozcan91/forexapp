package com.example.forexapp.dto;

import lombok.Data;

@Data
public class ExchangeRateResponse {
    private String fromCurrency;
    private String toCurrency;
    private double rate;
}
