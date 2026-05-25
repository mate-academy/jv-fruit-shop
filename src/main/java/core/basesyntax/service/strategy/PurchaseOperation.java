package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int old = Storage.getStorage().getOrDefault(transaction.getFruit(), 0);
        if (old < transaction.getQuantity()) {
            throw new RuntimeException("Not enough " + transaction.getFruit() + " in storage");
        }
        Storage.getStorage().put(transaction.getFruit(), old - transaction.getQuantity());
    }
}
