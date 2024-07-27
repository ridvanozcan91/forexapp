package com.example.forexapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Schema(description = "Request to convert currency")
public class CurrencyConversionRequest {
    @Schema(description = "Amount to be converted", example = "100")
    @Positive
    private double amount;
    @Schema(description = "Source currency code", example = "USD")
    @NotEmpty
    private String fromCurrency;
    @Schema(description = "Target currency code", example = "EUR")
    @NotEmpty
    private String toCurrency;
}
