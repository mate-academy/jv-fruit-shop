package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class ReturnHandler implements StoreOperationsHandler {
    @Override
    public void operation(Storage storage, String product, int quantity) {
        returnItem(storage, product, quantity);
    }

    private void returnItem(Storage storage, String product, int quantity) {
        storage.add(product, quantity);
    }

}
