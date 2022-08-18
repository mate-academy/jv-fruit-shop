package core.operations;

import core.model.FruitTransaction;
import core.storage.Storage;

public class BalanceOperation implements Operation {
    private Storage storage;

    public BalanceOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void performOperation(FruitTransaction fruitTransaction) {
        storage.add(fruitTransaction.getFruit(), fruitTransaction.getCount());
    }
}
