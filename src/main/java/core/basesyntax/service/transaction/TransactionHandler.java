package core.basesyntax.service.transaction;

import core.basesyntax.model.FruitTransaction;

public interface TransactionHandler {
    void handleTransaction(FruitTransaction transaction);
}
