package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class SupplyHandler implements StoreOperationsHandler {
    @Override
    public void applyOperation(Storage storage, String product, int quantity) {
        supply(storage, product, quantity);
    }

    private void supply(Storage storage, String product, int quantity) {
        storage.add(product, quantity);
    }
}
