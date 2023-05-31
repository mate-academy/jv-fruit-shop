package core.basesyntax.strategy.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handler.OperationHandler;

public class BalanceHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        if (transaction.getQuantity() >= 0) {
            Storage.put(transaction.getFruit(), transaction.getQuantity());
        } else {
            throw new RuntimeException("Quantity of fruits shouldn't be less than 0, but it was: "
                    + transaction.getQuantity());
        }
    }
}
