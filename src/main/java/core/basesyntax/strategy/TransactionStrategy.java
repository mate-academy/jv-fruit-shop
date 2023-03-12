package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface TransactionStrategy {
    TransactionHandler get(FruitTransaction.Operation operation);
}
