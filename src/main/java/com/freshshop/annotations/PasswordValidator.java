package com.freshshop.annotations;

import com.freshshop.validator.PasswordStrengthValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
//@Constraint: annotation indicates that this annotation is used to define a
// constraint and specifies the class that implements the constraint validation logic
@Constraint(validatedBy = PasswordStrengthValidator.class)

//The @Target annotation indicates the type of elements
//this annotation can be applied to, in this case, it can be applied to methods and fields.
@Target({ ElementType.METHOD, ElementType.FIELD })

//The @Retention annotation indicates the retention policy of the annotation, in this case,
// it is set to RetentionPolicy.RUNTIME,
// which means that the annotation will be available at runtime through reflection.
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordValidator { // @interface is a special Java keyword used to define a custom annotation
	// specifies the error message to be returned
	// if the constraint validation fails.4
	String message() default "Please choose a strong password";

	Class<?>[] groups() default {}; // specifies the validation groups targeted by this constraint.

	Class<? extends Payload>[] payload() default {}; // specifies additional metadata that can be attached to a
														// constraint
}
