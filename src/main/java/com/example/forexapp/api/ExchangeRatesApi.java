package com.example.forexapp.api;

import com.example.forexapp.dto.ExchangeRateResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Validated
@RequestMapping("/api/v1/exchange-rates")
public interface ExchangeRatesApi {

    @Operation(summary = "Get Exchange Rate", description = "Get the current exchange rate between two currencies.", responses = {@ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                {
                    "rate": 0.85
                }
            """)))})
    @GetMapping
    ExchangeRateResponse getExchangeRate(@RequestParam @NotEmpty String fromCurrency, @RequestParam @NotEmpty String toCurrency);
}
