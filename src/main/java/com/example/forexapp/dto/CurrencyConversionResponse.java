package com.example.forexapp.dto;

import lombok.Data;

@Data
public class CurrencyConversionResponse {
    private double convertedAmount;
    private String transactionId;
}
