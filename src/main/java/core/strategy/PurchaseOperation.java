package core.strategy;

import core.db.Storage;
import core.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void process(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        int current = Storage.get(fruit);
        if (quantity > current) {
            throw new RuntimeException("Not enough " + fruit + " in storage! Available: "
                    + current + ", requested: " + quantity);
        }
        int newCurrent = current - quantity;
        Storage.put(fruit, newCurrent);
    }
}
