package core.basesyntax.strategy;

import core.basesyntax.service.FruitTransaction;

public interface OperationStrategy {
    FruitOperationHandler get(FruitTransaction.Operation operation);
}
