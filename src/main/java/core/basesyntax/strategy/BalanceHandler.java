package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class BalanceHandler implements StoreOperationsHandler {
    @Override
    public void applyOperation(Storage storage, String product, int quantity) {
        balance(storage, product, quantity);
    }

    private void balance(Storage storage, String product, int quantity) {
        storage.add(product, quantity);
    }
}
