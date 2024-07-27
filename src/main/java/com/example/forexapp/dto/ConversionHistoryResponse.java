package com.example.forexapp.dto;

import com.example.forexapp.model.CurrencyConversion;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
@AllArgsConstructor
public class ConversionHistoryResponse {
    @Schema(description = "Paginated list of currency conversions")
    private Page<CurrencyConversion> conversions;
}
