package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private static final int DEFAULT_QUANTITY = 0;

    @Override
    public void operate(FruitTransaction fruitTransaction) {
        int amount = Storage.addFruits(fruitTransaction.getFruit(), DEFAULT_QUANTITY);
        int purchase = amount - fruitTransaction.getQuantity();
        if (purchase < 0) {
            throw new RuntimeException("Quantity can't be less than you want buy");
        } else {
            Storage.addFruits(fruitTransaction.getFruit(), purchase);
        }
    }
}
