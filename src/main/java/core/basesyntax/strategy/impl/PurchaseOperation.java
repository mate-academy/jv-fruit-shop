package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void doTransaction(String fruitName, int quantity) {
        int currentCapacity = Storage.getFruitQuantity(fruitName);
        if (currentCapacity >= quantity) {
            Storage.substractFruitQuantity(fruitName, quantity);
        } else {
            throw new RuntimeException("Not enough " + fruitName
                   + "for purchase, attempted to buy: "
                   + quantity + "but only: " + currentCapacity);
        }
    }
}
