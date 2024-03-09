package com.freshshop.annotations;

import com.freshshop.validator.FieldMatcherValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FieldMatcherValidator.class)
@Target(ElementType.TYPE)
//The @Target annotation indicates the type of element this annotation can be applied to,
// in this case, it can be applied to a class.
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldsValueMatch {
	String message() default "Fields value don't match";

	Class<?>[] groups() default {}; // specifies the validation groups targeted by this constraint.

	Class<? extends Payload>[] payload() default {}; // specifies additional metadata that can be attached to a
														// constraint

	// The field() method specifies the name of the field to be validated.
	String field();

	// The fieldMatch() method specifies the name of the field whose value should
	// match the field() value.
	String fieldMatch();

	@Target({ ElementType.TYPE })
	@Retention(RetentionPolicy.RUNTIME)
	@interface List {
		FieldsValueMatch[] value();
		// The @interface List annotation is an inner annotation that
		// allows for the specification of multiple instances of the FieldsValueMatch
		// annotation.
		// This is useful when a class has multiple fields that need to be validated
		// against each other.
	}

}
