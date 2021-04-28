package core.basesyntax.validator.type;

import core.basesyntax.model.OperationType;
import core.basesyntax.validator.quantity.UnavailableQuantityException;

public class TypeValidatorImpl implements TypeValidator {
    @Override
    public void isTypeCorrect(String type, int lineNumber) {
        if (!OperationType.isMember(type)) {
            throw new UnavailableQuantityException("No such type on line " + lineNumber);
        }
    }
}
