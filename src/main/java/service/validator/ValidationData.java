package service.validator;

import exception.ValidationException;

public interface ValidationData<T> {
    void validate(T value) throws ValidationException;
}
