package core.basesyntax.service.interfaces;

import core.basesyntax.ValidationException;

public interface FileValidator<T> {
    void validate(T value) throws ValidationException;
}
