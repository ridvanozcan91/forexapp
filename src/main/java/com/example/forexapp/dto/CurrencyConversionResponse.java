package com.example.forexapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Response for currency conversion")
public class CurrencyConversionResponse {
    @Schema(description = "Converted amount", example = "85")
    private double convertedAmount;
    @Schema(description = "Transaction identifier", example = "123e4567-e89b-12d3-a456-426614174000")
    private String transactionId;
}
