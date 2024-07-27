package com.example.forexapp.controller;

import com.example.forexapp.dto.ConversionHistoryRequest;
import com.example.forexapp.dto.ConversionHistoryResponse;
import com.example.forexapp.service.CurrencyConversionService;
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

    @GetMapping("/conversions")
    public ResponseEntity<ConversionHistoryResponse> getConversionHistory(
            @Valid @RequestBody ConversionHistoryRequest request,
            Pageable pageable) {
        ConversionHistoryResponse response = currencyConversionService.getConversionHistory(request, pageable);
        return ResponseEntity.ok(response);
    }
}
