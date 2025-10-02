package strategy;

import db.Storage;
import model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int current = Storage.getQuantity(fruit);
        int newBalance = current - transaction.getQuantity();
        if (newBalance < 0) {
            throw new RuntimeException("Negative balance for fruit: " + fruit);
        }
        Storage.setQuantity(fruit, newBalance);
    }
}
