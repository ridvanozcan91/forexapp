package com.example.forexapp.controller;

import com.example.forexapp.dto.ConversionHistoryRequest;
import com.example.forexapp.dto.ConversionHistoryResponse;
import com.example.forexapp.service.CurrencyConversionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Validated
public class ConversionHistoryController {

    private final CurrencyConversionService currencyConversionService;

    @Operation(summary = "Get Conversion History", description = "Get a paginated list of currency conversions filtered by transaction ID or transaction date.", responses = {@ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
                {
                    "conversions": {
                        "content": [
                            {
                                "id": 1,
                                "fromCurrency": "USD",
                                "toCurrency": "EUR",
                                "amount": 100,
                                "convertedAmount": 85,
                                "transactionId": "123e4567-e89b-12d3-a456-426614174000",
                                "transactionDate": "2024-07-27"
                            }
                        ],
                        "pageable": {
                            "sort": {
                                "empty": false,
                                "unsorted": false,
                                "sorted": true
                            },
                            "offset": 0,
                            "pageNumber": 0,
                            "pageSize": 10,
                            "paged": true,
                            "unpaged": false
                        },
                        "totalElements": 1,
                        "totalPages": 1,
                        "last": true,
                        "size": 10,
                        "number": 0,
                        "sort": {
                            "empty": false,
                            "unsorted": false,
                            "sorted": true
                        },
                        "numberOfElements": 1,
                        "first": true,
                        "empty": false
                    }
                }
            """)))})
    @GetMapping("/conversions")
    public ResponseEntity<ConversionHistoryResponse> getConversionHistory(@Valid @RequestBody ConversionHistoryRequest request, Pageable pageable) {
        ConversionHistoryResponse response = currencyConversionService.getConversionHistory(request, pageable);
        return ResponseEntity.ok(response);
    }
}
