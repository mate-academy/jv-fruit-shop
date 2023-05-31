package core.basesyntax.strategy.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handler.OperationHandler;

public class ReturnHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        if (transaction.getQuantity() <= 0) {
            throw new RuntimeException("Quantity of fruits shouldn't be less than 0 but it was: "
                    + transaction.getQuantity());
        }
        int quantityInStock = Storage.get(transaction.getFruit());
        Storage.put(transaction.getFruit(), transaction.getQuantity() + quantityInStock);
    }
}
