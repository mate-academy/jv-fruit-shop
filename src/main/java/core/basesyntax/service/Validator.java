package core.basesyntax.service;

import core.basesyntax.exception.ValidationException;

public interface Validator<T> {
    void validate(T value) throws ValidationException;
}
