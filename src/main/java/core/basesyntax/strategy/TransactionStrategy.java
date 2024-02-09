package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface TransactionStrategy {
    TransactionStrategy balanceUpdater(FruitTransaction.Operation operation);
}
