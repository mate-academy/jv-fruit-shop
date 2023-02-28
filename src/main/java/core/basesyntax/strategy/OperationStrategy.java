package core.basesyntax.strategy;

import core.basesyntax.dao.FruitTransaction;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operationType);
}
