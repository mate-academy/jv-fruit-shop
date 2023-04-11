package core.basesyntax.strategy.transaction;

import core.basesyntax.model.FruitTransaction;

public interface TransactionHandler {
    void operate(FruitTransaction transaction);
}
