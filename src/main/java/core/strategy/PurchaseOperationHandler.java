package core.strategy;

import core.db.Storage;
import core.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        if (Storage.fruits.get(fruit) > quantity) {
            Storage.fruits.put(fruit,
                    (Storage.fruits.get(fruit) - quantity));
        } else {
            throw new RuntimeException("not enough goods, you had "
                    + Storage.fruits.get(fruit) + "but it was sold " + quantity);
        }
    }
}
