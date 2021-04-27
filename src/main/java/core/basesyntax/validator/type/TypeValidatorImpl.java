package core.basesyntax.validator.type;

import core.basesyntax.validator.quantity.UnavailableQuantity;

import java.util.Set;

public class TypeValidatorImpl implements TypeValidator {
    @Override
    public void isTypeCorrect(String type,
                              Set<String> availableTypes, int lineNumber) {
        try {
            if (!availableTypes.contains(type)) {
                throw new UnavailableQuantity();
            }
        } catch (UnavailableQuantity e) {
            throw new RuntimeException(
                    "No such type on line " + lineNumber, e);
        }
    }
}
