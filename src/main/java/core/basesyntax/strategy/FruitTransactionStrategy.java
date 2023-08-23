package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface FruitTransactionStrategy {
    FruitTransactionHandler getTransaction(FruitTransaction.Operation operation);
}
