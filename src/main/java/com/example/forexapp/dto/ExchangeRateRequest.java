package com.example.forexapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Request to get exchange rate")
public class ExchangeRateRequest {
    @Schema(description = "Source currency code", example = "USD")
    private String fromCurrency;
    @Schema(description = "Target currency code", example = "EUR")
    private String toCurrency;
}
