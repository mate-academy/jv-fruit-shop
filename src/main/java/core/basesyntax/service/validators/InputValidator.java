package core.basesyntax.service.validators;

import core.basesyntax.exceptions.InvalidInputException;
import java.util.List;

public interface InputValidator {
    void validate(List<String> data) throws InvalidInputException;
}
