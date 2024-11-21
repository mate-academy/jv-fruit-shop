package fruitshop.strategy.impl;

import fruitshop.db.Storage;
import fruitshop.model.FruitTransaction;
import fruitshop.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        Storage.fruits.put(fruit, Storage.fruits.getOrDefault(fruit, 0) + quantity);
    }
}
