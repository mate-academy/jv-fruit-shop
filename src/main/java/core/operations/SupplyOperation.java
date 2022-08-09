package core.operations;

import core.FruitTransaction;
import core.storage.Storage;

public class SupplyOperation implements Operation {
    @Override
    public void performOperation(Storage storage, FruitTransaction fruitTransaction) {
        storage.add(fruitTransaction.getFruit(), fruitTransaction.getCount());
    }
}
