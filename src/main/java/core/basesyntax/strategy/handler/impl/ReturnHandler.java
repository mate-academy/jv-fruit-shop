package core.basesyntax.strategy.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handler.OperationHandler;

public class ReturnHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        if (transaction.getQuantity() > 0) {
            int oldQuantity = Storage.get(transaction.getFruit());
            Storage.put(transaction.getFruit(), transaction.getQuantity() + oldQuantity);
        } else {
            throw new RuntimeException("Quantity of fruits should be greater than 0 but it was: "
                    + transaction.getQuantity());
        }

    }
}
