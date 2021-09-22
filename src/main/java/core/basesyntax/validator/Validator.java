package core.basesyntax.validator;

import core.basesyntax.exception.ValidatorException;

public interface Validator<T> {
    boolean validate(T recordsList) throws ValidatorException;
}
