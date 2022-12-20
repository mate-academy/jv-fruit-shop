package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
