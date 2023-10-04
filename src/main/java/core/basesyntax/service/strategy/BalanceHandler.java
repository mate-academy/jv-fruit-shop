package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;

public class BalanceHandler implements TransactionHandler {
    @Override
    public void transaction(String fruit, int quantity) {
        Storage.STORAGE.put(fruit, quantity);
    }
}
