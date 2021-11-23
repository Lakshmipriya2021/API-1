package com.springboot1.validator;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Constraint(validatedBy = UserDobValidator.class)
public @interface UserDob {

    String message() default "This date pattern is not allowed.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}