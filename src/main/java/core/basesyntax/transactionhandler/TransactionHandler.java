package core.basesyntax.transactionhandler;

import core.basesyntax.model.FruitTransaction;

public interface TransactionHandler {
    void handleTransaction(FruitTransaction transaction);
}
