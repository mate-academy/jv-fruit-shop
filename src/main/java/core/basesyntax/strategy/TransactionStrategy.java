package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface TransactionStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
