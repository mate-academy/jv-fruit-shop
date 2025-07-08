package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void operate(FruitTransaction transaction) {
        if (transaction == null) {
            throw new RuntimeException("Transaction can not be null");
        }
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("Quantity can't be negative: " + transaction.getQuantity());
        }
        int oldQuantity = Storage.fruits.get(transaction.getFruit());
        int newQuantity = oldQuantity - transaction.getQuantity();
        if (newQuantity < 0) {
            throw new RuntimeException("The purchase quantity is more than balance: "
                    + transaction.getQuantity());
        }
        Storage.fruits.put(transaction.getFruit(), newQuantity);
    }
}
