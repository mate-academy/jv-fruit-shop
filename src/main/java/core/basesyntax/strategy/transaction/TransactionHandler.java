package core.basesyntax.strategy.transaction;

import core.basesyntax.model.FruitTransaction;

public interface TransactionHandler {
    void handle(FruitTransaction transaction);
}
