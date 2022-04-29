package core.basesyntax.service;

import core.basesyntax.exception.ValidationException;
import java.util.List;

public interface Validator<T> {
    void validate(List<T> dataFromFile) throws ValidationException;
}
