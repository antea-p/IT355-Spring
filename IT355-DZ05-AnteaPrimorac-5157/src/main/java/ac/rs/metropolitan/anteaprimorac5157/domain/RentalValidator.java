package ac.rs.metropolitan.anteaprimorac5157.domain;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class RentalValidator implements Validator {

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String LICENSE_REGEX = "^[A-Z]{2}-\\d{4}-[A-Z]{2}$";

    @Override
    public boolean supports(Class<?> clazz) {
        return Rental.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Rental rental = (Rental) target;

        ValidationUtils.rejectIfEmpty(errors, "car.id", "required.carId", "Please select a car.");

        User user = rental.getUser();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.fullName", "required.fullName", "Full name is required.");

        if (!user.getEmail().matches(EMAIL_REGEX)) {
            errors.rejectValue("user.email", "email.invalid", "Email is invalid.");
        }

        if (!user.getLicenseNumber().matches(LICENSE_REGEX)) {
            errors.rejectValue("user.licenseNumber", "license.invalid", "License is case sensitive and must be in form: AB-1234-CD");
        }

    }
}

