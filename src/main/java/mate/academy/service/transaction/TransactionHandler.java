package mate.academy.service.transaction;

import mate.academy.model.FruitTransaction;

public interface TransactionHandler {
    void handleTransaction(FruitTransaction transaction);
}
