package core.basesyntax.strategy;

import core.basesyntax.service.impl.FruitTransaction;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
