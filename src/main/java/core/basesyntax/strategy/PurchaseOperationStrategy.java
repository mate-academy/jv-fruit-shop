package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationStrategy implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        int quantityOfParchedFruits = transaction.getQuantity();
        int oldQuantity = Storage.fruits.get(fruitName);
        Storage.fruits.put(fruitName, oldQuantity - quantityOfParchedFruits);
    }
}
