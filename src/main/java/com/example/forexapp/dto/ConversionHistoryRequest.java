package com.example.forexapp.dto;

import com.example.forexapp.validation.OneRequired;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@OneRequired
public class ConversionHistoryRequest {
    private String transactionId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @PastOrPresent(message = "Transaction date cannot be in the future")
    private LocalDate transactionDate;
}
