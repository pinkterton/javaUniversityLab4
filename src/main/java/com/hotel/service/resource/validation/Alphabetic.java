package com.hotel.service.resource.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AlphabeticValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface Alphabetic {
    String message() default "Field must contain only alphabetic characters";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
