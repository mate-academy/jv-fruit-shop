package core.basesyntax.service;

import core.basesyntax.models.FruitTransaction;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
