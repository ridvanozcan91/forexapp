package com.example.forexapp.validation;

import com.example.forexapp.dto.ConversionHistoryRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class OneRequiredValidator implements ConstraintValidator<OneRequired, ConversionHistoryRequest> {
    @Override
    public boolean isValid(ConversionHistoryRequest request, ConstraintValidatorContext context) {
        return request.getTransactionId() != null || request.getTransactionDate() != null;
    }
}
