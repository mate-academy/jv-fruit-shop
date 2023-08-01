package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class PurchaseHandler implements StoreOperationsHandler {
    @Override
    public void operation(Storage storage, String product, int quantity) {
        purchase(storage, product, quantity);
    }

    private void purchase(Storage storage, String product, int quantity) {
        storage.remove(product, quantity);
    }
}
