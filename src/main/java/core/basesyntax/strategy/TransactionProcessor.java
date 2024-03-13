package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface TransactionProcessor {
    void processTransaction(FruitTransaction transaction);
}
