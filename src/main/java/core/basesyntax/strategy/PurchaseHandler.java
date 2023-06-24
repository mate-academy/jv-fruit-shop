package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.models.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        int quantityOfParchedFruits = fruitTransaction.getQuantity();
        int oldQuantity = Storage.fruits.get(fruitName);
        if (oldQuantity < quantityOfParchedFruits) {
            throw new IllegalArgumentException("Not enough fruits available");
        }
        Storage.fruits.put(fruitName, oldQuantity - quantityOfParchedFruits);
    }
}
