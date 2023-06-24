package core.strategy;

import core.db.Storage;
import core.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        if (Storage.fruits.containsKey(fruit)) {
            Storage.fruits.put(fruit, (Storage.fruits.get(fruit) + quantity));
        } else {
            Storage.fruits.put(fruit, quantity);
        }
    }
}
