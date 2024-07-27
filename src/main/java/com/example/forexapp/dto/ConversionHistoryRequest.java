package com.example.forexapp.dto;

import com.example.forexapp.validation.OneRequired;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@OneRequired
public class ConversionHistoryRequest {
    @Schema(description = "Transaction ID for filtering")
    private String transactionId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @PastOrPresent(message = "Transaction date cannot be in the future")
    @Schema(description = "Transaction Date for filtering", example = "2024-07-27")
    private LocalDate transactionDate;
}
