package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void handle(Storage storage, FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantityToBuy = fruitTransaction.getQuantity();
        int currentQuantity = storage.fruits.getOrDefault(fruit, 0);

        if (currentQuantity >= quantityToBuy) {
            int newQuantity = currentQuantity - quantityToBuy;
            storage.fruits.put(fruit, newQuantity);

            if (newQuantity < 0) {
                throw new RuntimeException("Incorrect quantity "
                        + fruit + " quantity can't has negative value");
            }
        } else {
            System.err.println("Not enough "
                    + fruit + " available for purchase. Current stock: " + currentQuantity);
        }
    }
}
