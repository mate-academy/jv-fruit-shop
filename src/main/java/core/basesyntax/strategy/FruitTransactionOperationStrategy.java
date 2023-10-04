package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface FruitTransactionOperationStrategy {
    FruitTransactionOperationHandler getHandler(FruitTransaction.Operation operation);
}
