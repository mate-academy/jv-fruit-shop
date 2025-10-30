package service.basesyntax.service.strategy;

import service.basesyntax.db.Storage;
import service.basesyntax.model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    public void apply(Storage storage, FruitTransaction transaction) {
        if (storage == null) {
            throw new NullPointerException("storage is null");
        }
        if (transaction == null) {
            throw new NullPointerException("transaction is null");
        }
        int newQuantity = storage.get(transaction.getFruit()) - transaction.getQuantity();
        if (newQuantity < 0) {
            throw new ArithmeticException("Not enough "
                    + transaction.getFruit()
                    + "in the store."
                    + " Available: "
                    + storage.get(transaction.getFruit())
                    + ", requested: "
                    + transaction.getQuantity());
        }
        storage.put(transaction.getFruit(), newQuantity);
    }
}
