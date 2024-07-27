package com.example.forexapp.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = OneRequiredValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface OneRequired {
    String message() default "Either transactionId or transactionDate must be provided";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
