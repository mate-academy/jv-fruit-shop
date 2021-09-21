package core.basesyntax.service.parser.validator;

import core.basesyntax.exception.ValidationException;

public interface Validator {
    void validate(String value) throws ValidationException;
}
