package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int result = Storage.get(transaction.getFruit()) - transaction.getQuantity();
        if (result < 0) {
            throw new RuntimeException("Not enough " + transaction.getFruit() + " in storage!");
        }
        Storage.put(transaction.getFruit(), result);
    }
}
