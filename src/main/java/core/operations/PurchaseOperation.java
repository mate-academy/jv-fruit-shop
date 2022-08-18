package core.operations;

import core.model.FruitTransaction;
import core.storage.Storage;

public class PurchaseOperation implements Operation {
    private Storage storage;

    public PurchaseOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void performOperation(FruitTransaction fruitTransaction) {
        storage.remove(fruitTransaction.getFruit(), fruitTransaction.getCount());
    }
}
