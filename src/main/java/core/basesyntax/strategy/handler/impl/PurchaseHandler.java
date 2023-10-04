package core.basesyntax.strategy.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handler.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int quantityInStock = Storage.get(transaction.getFruit());
        if (transaction.getQuantity() > quantityInStock || transaction.getQuantity() <= 0) {
            throw new RuntimeException("Quantity of fruits should be greater than 0, but it was: "
                    + transaction.getQuantity());
        }
        Storage.put(transaction.getFruit(), quantityInStock - transaction.getQuantity());
    }
}
