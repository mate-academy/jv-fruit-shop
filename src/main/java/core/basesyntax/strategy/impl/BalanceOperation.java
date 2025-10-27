package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperation implements OperationHandler {

    @Override
    public void doTransaction(String fruitName, int quantity) {
        Storage.setFruitQuantity(fruitName, quantity);
    }
}
