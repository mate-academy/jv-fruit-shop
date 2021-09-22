package service.validator;

import exception.ValidationException;

public interface DataValidator<T> {
    void validate(T value) throws ValidationException;
}
