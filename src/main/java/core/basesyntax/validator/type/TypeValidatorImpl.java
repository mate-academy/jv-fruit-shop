package core.basesyntax.validator.type;

import core.basesyntax.model.OperationType;

public class TypeValidatorImpl implements TypeValidator {
    @Override
    public void isTypeCorrect(String type, int lineNumber) {
        if (!OperationType.isPresent(type)) {
            throw new UnavaliableTypeException("No such type on line " + lineNumber);
        }
    }
}
