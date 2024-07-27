package com.example.forexapp.repository;

import com.example.forexapp.model.CurrencyConversion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CurrencyConversionRepository extends JpaRepository<CurrencyConversion, Long> {
    Page<CurrencyConversion> findByTransactionId(String transactionId, Pageable pageable);

    Page<CurrencyConversion> findByTransactionDate(LocalDate transactionDate, Pageable pageable);

    Page<CurrencyConversion> findByTransactionDateAndTransactionId(LocalDate transactionDate, String transactionId, Pageable pageable);
}

