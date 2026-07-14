package core.basesyntax.activities;

import core.basesyntax.maps.StorageForFruitsAndQuantity;
import core.basesyntax.transactions.FruitTransaction;

public class Balance implements OperationHandler {
    private StorageForFruitsAndQuantity storage;

    public Balance(StorageForFruitsAndQuantity storage) {
        this.storage = storage;
    }

    @Override
    public void operationHandler(FruitTransaction fruitTransaction) {

        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();

        storage.getStorage().put(fruit, quantity);
    }
}
