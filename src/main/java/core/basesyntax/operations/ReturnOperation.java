package core.basesyntax.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void apply(Storage storage, FruitTransaction transaction) {
        if (storage == null) {
            throw new IllegalArgumentException("Storage cannot be null.");
        }
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction cannot be null.");
        }
        if (transaction.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        int currentQuantity = storage.getQuantity(transaction.getFruit());
        int newQuantity = currentQuantity + transaction.getQuantity();

        storage.updateFruit(transaction.getFruit(), newQuantity);
    }
}
