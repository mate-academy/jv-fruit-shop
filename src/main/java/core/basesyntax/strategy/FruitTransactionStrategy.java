package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface FruitTransactionStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
