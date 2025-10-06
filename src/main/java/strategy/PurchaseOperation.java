package strategy;

import db.Storage;
import model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction null");
        }

        String fruit = transaction.getFruit();
        int current = Storage.getQuantity(fruit);
        int newQty = current - transaction.getQuantity();

        if (newQty < 0) {
            throw new RuntimeException("Negative balance for " + fruit);
        }

        Storage.setQuantity(fruit, newQty);
    }
}
