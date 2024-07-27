package com.example.forexapp.controller;

import com.example.forexapp.dto.ExchangeRateRequest;
import com.example.forexapp.dto.ExchangeRateResponse;
import com.example.forexapp.service.ExchangeRateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/exchange-rate")
@RequiredArgsConstructor
@Validated
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    @Operation(summary = "Get Exchange Rate", description = "Get the current exchange rate between two currencies.", responses = {@ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                {
                    "rate": 0.85
                }
            """)))})
    @GetMapping
    public ResponseEntity<ExchangeRateResponse> getExchangeRate(@RequestParam @NonNull String fromCurrency, @RequestParam @NonNull String toCurrency) {
        ExchangeRateRequest request = new ExchangeRateRequest();
        request.setFromCurrency(fromCurrency);
        request.setToCurrency(toCurrency);
        ExchangeRateResponse response = exchangeRateService.getExchangeRate(request);
        return ResponseEntity.ok(response);
    }
}
