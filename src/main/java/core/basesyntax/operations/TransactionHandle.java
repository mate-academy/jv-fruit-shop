package core.basesyntax.operations;

import core.basesyntax.model.FruitTransaction;

public interface TransactionHandle {
    void executeTransaction(FruitTransaction fruitTransaction);
}
