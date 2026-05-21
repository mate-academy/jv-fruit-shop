package service.operation;

import db.Storage;
import model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();

        int currentQuantity = Storage.fruitStorage.getOrDefault(fruit, 0);

        int updatedQuantity = currentQuantity - transaction.getQuantity();
        if (updatedQuantity < 0) {
            throw new RuntimeException("Not enough " + fruit + " in storage");
        }

        Storage.fruitStorage.put(fruit, updatedQuantity);
    }
}
