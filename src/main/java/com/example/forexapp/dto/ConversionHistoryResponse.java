package com.example.forexapp.dto;

import com.example.forexapp.model.CurrencyConversion;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class ConversionHistoryResponse {
    private Page<CurrencyConversion> conversions;
}
