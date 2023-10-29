package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface TransactionHandlerStrategy {
    TransactionHandler get(FruitTransaction.Operation operation);
}
