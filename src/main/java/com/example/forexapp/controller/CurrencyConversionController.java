package com.example.forexapp.controller;

import com.example.forexapp.dto.CurrencyConversionRequest;
import com.example.forexapp.dto.CurrencyConversionResponse;
import com.example.forexapp.service.CurrencyConversionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/exchange-rate")
@RequiredArgsConstructor
public class CurrencyConversionController {

    private final CurrencyConversionService currencyConversionService;

    @Operation(summary = "Convert Currency", description = "Convert an amount from one currency to another.", responses = {@ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                {
                    "convertedAmount": 85,
                    "transactionId": "123e4567-e89b-12d3-a456-426614174000"
                }
            """)))})
    @PostMapping("/convert")
    public ResponseEntity<CurrencyConversionResponse> convertCurrency(@RequestBody CurrencyConversionRequest request) {
        CurrencyConversionResponse response = currencyConversionService.convertCurrency(request);
        return ResponseEntity.ok(response);
    }
}
