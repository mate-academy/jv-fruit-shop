package fruitshop.strategy.impl;

import fruitshop.db.Storage;
import fruitshop.model.FruitTransaction;
import fruitshop.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        int currentStock = Storage.fruits.getOrDefault(fruit, 0);

        if (currentStock < quantity) {
            throw new RuntimeException("Not enough stock to purchase " + quantity + " " + fruit);
        }

        Storage.fruits.put(fruit, currentStock - quantity);
    }
}
