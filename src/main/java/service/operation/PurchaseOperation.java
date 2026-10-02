package service.operation;

import db.Storage;
import model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int currentQuantity = Storage.fruits.getOrDefault(fruit, 0);
        int requestedQuantity = transaction.getQuantity();

        if (currentQuantity < requestedQuantity) {
            throw new RuntimeException("Not enough " + fruit + " in stock! Available: "
            + currentQuantity + ", requested: " + requestedQuantity);
        }

        Storage.fruits.put(fruit, currentQuantity - requestedQuantity);
    }
}
