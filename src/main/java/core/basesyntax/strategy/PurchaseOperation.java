package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void handle(Storage storage, FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantityToBuy = fruitTransaction.getQuantity();
        int currentQuantity = storage.getFruits().getOrDefault(fruit, 0);

        if (currentQuantity >= quantityToBuy) {
            int newQuantity = currentQuantity - quantityToBuy;
            if (newQuantity >= 0) {
                storage.getFruits().put(fruit, newQuantity);
            }
        } else {
            throw new RuntimeException("Not enough "
                    + fruit + " available for purchase. Current stock: " + currentQuantity);
        }
    }
}
