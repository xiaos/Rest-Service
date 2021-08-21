package com.csz.rest.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Repeatable(EnumString.List.class)
@Documented
@Constraint(validatedBy = EnumStringValidator.class)
public @interface EnumString {

    String message() default "value not in enum values";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] value();

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        EnumString[] value();
    }
}
