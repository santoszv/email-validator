/*
 *    Copyright 2016 Santos Zatarain Vera
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

package mx.com.inftel.constraints.email;

import mx.com.inftel.constraints.email.validators.EmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {EmailValidator.class})
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE,
        ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {

    /**
     * Determines if {@code null} is a valid value.
     *
     * @return {@code true} bu default, {@code null} is a valid value by default.
     */
    boolean isNullValueValid() default true;

    /**
     * Dertermines if {@code ""} (empty string) is a valid value. Web forms usually send <em>empty fields</em>,
     * this flag is intended for these cases.
     *
     * @return {@code false} by default, empty string is not a valid value by default.
     */
    boolean isEmptyValueValid() default true;

    /**
     * Standard message template.
     *
     * @return Default message template string.
     */
    String message() default "{mx.com.inftel.constraints.email.Email.message}";

    /**
     * Standard group validation.
     *
     * @return Empty array by default.
     */
    Class<?>[] groups() default {};

    /**
     * Standard payload for this constraint.
     *
     * @return Empty array by default.
     */
    Class<? extends Payload>[] payload() default {};

    /**
     * Standard {@code List} sub-element for multiple constraint specification.
     */
    @Documented
    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE,
            ElementType.CONSTRUCTOR, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        /**
         * Multiple {@code Email} specification.
         *
         * @return Empty array by default.
         */
        Email[] value();
    }
}
