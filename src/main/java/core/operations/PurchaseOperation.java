package core.operations;

import core.FruitTransaction;
import core.storage.Storage;

public class PurchaseOperation implements Operation {
    @Override
    public void performOperation(Storage storage, FruitTransaction fruitTransaction) {
        storage.removeFromStorage(fruitTransaction.getFruit(), fruitTransaction.getCount());
    }
}
