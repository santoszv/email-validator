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

package mx.com.inftel.constraints.email.validators;

import mx.com.inftel.constraints.email.Email;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Email, String> {

    private boolean nullValueValid;
    private boolean emptyValueValid;

    @Override
    public void initialize(Email constraintAnnotation) {
        nullValueValid = constraintAnnotation.isNullValueValid();
        emptyValueValid = constraintAnnotation.isEmptyValueValid();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return nullValueValid;
        }
        if (value.isEmpty()) {
            return emptyValueValid;
        }

        try {
            InternetAddress internetAddress = new InternetAddress(value);
            internetAddress.validate();
            return internetAddress.getAddress().equals(value);
        } catch (AddressException e) {
            return false;
        }
    }
}
