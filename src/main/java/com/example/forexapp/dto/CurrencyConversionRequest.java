package com.example.forexapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Request to convert currency")
public class CurrencyConversionRequest {
    @Schema(description = "Amount to be converted", example = "100")
    private double amount;
    @Schema(description = "Source currency code", example = "USD")
    private String fromCurrency;
    @Schema(description = "Target currency code", example = "EUR")
    private String toCurrency;
}
