package core.dao;

import core.exception.ValidationException;

public interface Validator<T> {
    void validate(String data) throws ValidationException;
}
