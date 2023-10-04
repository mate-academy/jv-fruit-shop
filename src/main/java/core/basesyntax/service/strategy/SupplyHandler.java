package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;

public class SupplyHandler implements TransactionHandler {
    @Override
    public void transaction(String fruit, int quantity) {
        int oldValue = Storage.STORAGE.get(fruit);
        Storage.STORAGE.put(fruit, oldValue + quantity);
    }
}
