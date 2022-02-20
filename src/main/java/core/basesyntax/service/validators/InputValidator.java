package core.basesyntax.service.validators;

import java.util.List;

public interface InputValidator {
    void validate(List<String> data) throws IllegalArgumentException;
}
