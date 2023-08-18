package core.basesyntax.interfaces;

import core.basesyntax.model.FruitTransaction;

public interface TransactionExecutor {
    void transactionExecute(FruitTransaction transaction);
}
