package com.app.client.utils;

import jakarta.validation.*;

import java.util.Set;

public final class ValidationCustom {
    private ValidationCustom() {
    }

    public static <T> T validator(T t) {
        final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        final Set<ConstraintViolation<T>> validate = validator.validate(t);
        if (!validate.isEmpty()) {
            throw new ConstraintViolationException(validate);
        }
        return t;
    }
}
