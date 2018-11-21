package org.dspace.compass.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author Anastasios Tsolakidis.
 * @author Nikolaos Christidis.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Pattern {
    
    String value() default "no-pattern";
}
