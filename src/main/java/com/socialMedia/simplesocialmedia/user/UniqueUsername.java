package com.socialMedia.simplesocialmedia.user;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {UniqueUsernameValidator.class})


public @interface UniqueUsername {
    String message() default "{simple.constraint.UniqueUsername.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload > [] payload() default {};


}
