package core.operations;

import core.FruitTransaction;
import core.storage.Storage;

public class ReturnOperation implements Operation {
    private Storage storage;

    public ReturnOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void performOperation(FruitTransaction fruitTransaction) {
        storage.add(fruitTransaction.getFruit(), fruitTransaction.getCount());
    }
}
