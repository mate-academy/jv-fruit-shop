package core.basesyntax.strategy.handler;

import core.basesyntax.model.FruitTransaction;

public interface TransactionHandler {
    void makeTransaction(FruitTransaction transaction);
}
