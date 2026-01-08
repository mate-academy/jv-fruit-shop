package strategy.impl;

import core.basesyntax.FruitTransaction;
import db.Storage;
import strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handler(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getFruit() == null || fruitTransaction.getQuantity() < 0) {
            throw new IllegalArgumentException("Fruit is null or quantity is less  than 0");
        }
        int currentQuantity = Storage.fruitStorage.getOrDefault(fruitTransaction.getFruit(), 0);
        int newFruitQuantity = currentQuantity - fruitTransaction.getQuantity();
        if (newFruitQuantity <= 0) {
            throw new RuntimeException(
                    "Fruits from the storage are not enough. Quantity: "
                            + newFruitQuantity);
        }
        Storage.fruitStorage
                .put(fruitTransaction.getFruit(), newFruitQuantity);

    }
}
