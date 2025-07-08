package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void operate(FruitTransaction transaction) {
        if (transaction == null) {
            throw new RuntimeException("Transaction can not be null");
        }
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("Quantity can't be negative " + transaction.getQuantity());
        }
        if (Storage.fruits.get(transaction.getFruit()) == null) {
            throw new RuntimeException("There is no such fruit in storage: "
                    + transaction.getFruit());
        }
        int oldQuantity = Storage.fruits.get(transaction.getFruit());
        int newQuantity = oldQuantity + transaction.getQuantity();
        if (newQuantity < 0) {
            throw new RuntimeException("Balance after supply can't be negative "
                    + transaction.getQuantity());
        }
        Storage.fruits.put(transaction.getFruit(), newQuantity);
    }
}
