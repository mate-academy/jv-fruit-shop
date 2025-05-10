package core.basesyntax.strategy;

import core.basesyntax.service.FruitTransaction;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
