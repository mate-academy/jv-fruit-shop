package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    private static final int DEFAULT_QUANTITY = 0;

    @Override
    public void operate(FruitTransaction fruitTransaction) {
        int amount = Storage.getInformation(fruitTransaction.getFruit(), DEFAULT_QUANTITY);
        Storage.addFruits(fruitTransaction.getFruit(), amount + fruitTransaction.getQuantity());
    }
}
