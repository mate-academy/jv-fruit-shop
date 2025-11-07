package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int currentQty = Storage.getQuantity(transaction.getFruit());
        if (currentQty < transaction.getQuantity()) {
            throw new RuntimeException("Not enough "
                    + transaction.getFruit() + " in stock for purchase. Current: "
                    + currentQty + ", requested: " + transaction.getQuantity());
        }
        Storage.addQuantity(transaction.getFruit(), -transaction.getQuantity());
    }
}
