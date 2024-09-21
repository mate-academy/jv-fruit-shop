package core.basesyntax.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(Storage storage, FruitTransaction transaction) {
        int currentQuantity = storage.getQuantity(transaction.getFruit());
        int newQuantity = currentQuantity - transaction.getQuantity();

        if (newQuantity < 0) {
            throw new RuntimeException("Insufficient stock for purchase of "
                    + transaction.getFruit());
        }

        storage.updateFruit(transaction.getFruit(), newQuantity);
    }
}



