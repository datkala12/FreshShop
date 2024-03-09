package com.freshshop.validator;

import com.freshshop.annotations.PasswordValidator;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

import java.lang.annotation.*;
import java.util.Arrays;
import java.util.List;

public class PasswordStrengthValidator implements ConstraintValidator<PasswordValidator, String> {
//    ConstraintValidator --- 1 param: Annotation
//                        --- 2 param: Type of the field that use this validation(Password--> String)
    List<String> weakPasswords;
    @Override
    public void initialize(PasswordValidator constraintAnnotation) {
        weakPasswords = Arrays.asList("12345", "qwerty", "password");
    }

    @Override
    public boolean isValid(String passwordFields, ConstraintValidatorContext context) {
        return passwordFields != null && (!weakPasswords.contains(passwordFields));
    }
}
