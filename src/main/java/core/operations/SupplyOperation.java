package core.operations;

import core.FruitTransaction;
import core.storage.Storage;

public class SupplyOperation implements Operation {
    private Storage storage;

    public SupplyOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void performOperation(FruitTransaction fruitTransaction) {
        storage.add(fruitTransaction.getFruit(), fruitTransaction.getCount());
    }
}
