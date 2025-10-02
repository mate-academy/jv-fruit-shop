package strategy;

import db.Storage;
import model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int current = Storage.getStorage().getOrDefault(fruit, 0);
        int newBalance = current - transaction.getQuantity();
        if (newBalance < 0) {
            throw new RuntimeException("Negative balance for fruit: " + fruit);
        }
        Storage.getStorage().put(fruit, newBalance);
    }
}
