package core.basesyntax.validator.type;

import java.util.Set;

public interface TypeValidator {
    void isTypeCorrect(String type,
                       Set<String> availableTypes, int lineNumber);
}
