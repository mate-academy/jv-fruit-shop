package core.basesyntax.services.handlers;

import core.basesyntax.models.FruitTransaction;

public interface OperationQuantityValidator {
    int validateAndGetOperationQuantity(FruitTransaction fruitTransaction);
}
