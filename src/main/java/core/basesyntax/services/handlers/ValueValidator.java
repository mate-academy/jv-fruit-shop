package core.basesyntax.services.handlers;

import core.basesyntax.models.FruitTransaction;

public interface ValueValidator {
    int validateAndGetOperationValue(FruitTransaction fruitTransaction);
}
