package com.example.forexapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Response for exchange rate")
public class ExchangeRateResponse {
    @Schema(description = "Source currency code", example = "USD")
    private String fromCurrency;
    @Schema(description = "Target currency code", example = "EUR")
    private String toCurrency;
    @Schema(description = "Exchange rate from source to target currency", example = "0.85")
    private double rate;
}
