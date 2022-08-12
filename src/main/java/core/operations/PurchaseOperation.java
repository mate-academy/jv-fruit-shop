package core.operations;

import core.FruitTransaction;
import core.storage.Storage;

public class PurchaseOperation implements Operation {
    private Storage storage;

    public PurchaseOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void performOperation(FruitTransaction fruitTransaction) {
        storage.removeFromStorage(fruitTransaction.getFruit(), fruitTransaction.getCount());
    }
}
