package com.example.forexapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fromCurrency;
    private String toCurrency;
    private double amount;
    private double convertedAmount;
    private String transactionId;
    private LocalDate transactionDate;

    @PrePersist
    public void onPrePersist() {
        this.transactionDate = LocalDate.now();
    }
}
