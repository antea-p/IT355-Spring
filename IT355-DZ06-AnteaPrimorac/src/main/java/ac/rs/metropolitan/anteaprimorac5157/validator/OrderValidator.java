package ac.rs.metropolitan.anteaprimorac5157.validator;

import ac.rs.metropolitan.anteaprimorac5157.entity.Order;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class OrderValidator implements Validator {

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return Order.class.equals(clazz);
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "field.required", "Name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "field.required", "Surname is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "field.required", "Address is required.");
    }
}