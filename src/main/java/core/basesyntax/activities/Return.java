package core.basesyntax.activities;

import core.basesyntax.maps.StorageForFruitsAndQuantity;
import core.basesyntax.transactions.FruitTransaction;

public class Return implements OperationHandler {
    private StorageForFruitsAndQuantity storage;

    public Return(StorageForFruitsAndQuantity storage) {
        this.storage = storage;
    }

    @Override
    public void operationHandler(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();

        int currentQuantity = storage.getStorage().getOrDefault(fruit, 0);
        int newQuantity = currentQuantity + quantity;
        storage.getStorage().put(fruit, newQuantity);
    }
}
