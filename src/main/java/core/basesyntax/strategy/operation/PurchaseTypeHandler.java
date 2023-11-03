package core.basesyntax.strategy.operation;

import static core.basesyntax.db.Storage.storage;

import core.basesyntax.model.FruitTransaction;

public class PurchaseTypeHandler implements OperationHandlers {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        int currentQuantity = storage.get(transaction.getFruit());
        if (currentQuantity - transaction.getQuantity() < 0) {
            throw new RuntimeException("Quantity cannot be less then 0!");
        }
        storage.put(transaction.getFruit(), currentQuantity
                - transaction.getQuantity());
    }
}
