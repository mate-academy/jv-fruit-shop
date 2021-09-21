package core.basesyntax.validator;

import core.basesyntax.ValidatorException;

public interface Validator<T> {
    boolean validate(T recordsList) throws ValidatorException;
}
