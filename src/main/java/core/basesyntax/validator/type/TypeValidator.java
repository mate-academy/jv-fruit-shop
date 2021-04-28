package core.basesyntax.validator.type;

import core.basesyntax.model.OperationType;

import java.util.Set;

public interface TypeValidator {
    void isTypeCorrect(String type, int lineNumber);
}
