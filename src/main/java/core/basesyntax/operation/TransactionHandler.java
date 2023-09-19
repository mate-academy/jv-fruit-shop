package core.basesyntax.operation;

import core.basesyntax.FruitTransaction;

public interface TransactionHandler {
    void applyTransaction(FruitTransaction transaction);
}
