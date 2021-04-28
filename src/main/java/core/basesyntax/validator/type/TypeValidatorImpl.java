package core.basesyntax.validator.type;

import core.basesyntax.model.OperationType;
import core.basesyntax.validator.quantity.UnavailableQuantity;

public class TypeValidatorImpl implements TypeValidator {
    @Override
    public void isTypeCorrect(String type, int lineNumber) {
        try {
            if (!OperationType.isMember(type)) {
                throw new UnavailableQuantity();
            }
        } catch (UnavailableQuantity e) {
            throw new RuntimeException(
                    "No such type on line " + lineNumber, e);
        }
    }
}
