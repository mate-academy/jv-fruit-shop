package strategy;

import db.Storage;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(String fruit, int quantity) {
        int fruitFromStorage = Storage.getInstance().getFruitStorage().getOrDefault(fruit, 0);
        int newFruitQuantity = fruitFromStorage - quantity;
        if (newFruitQuantity < 0) {
            throw new RuntimeException("Not enough " + fruit + " in storage");
        }
        Storage.getInstance().getFruitStorage().put(fruit, newFruitQuantity);
    }
}
