package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.QuantityException;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int quantity = Storage.fruits.get(transaction.getFruit());
        if (quantity >= transaction.getQuantity()) {
            Storage.fruits.put(transaction.getFruit(), quantity - transaction.getQuantity());
        } else {
            throw new QuantityException("Quantity is too large: " + quantity);
        }
    }
}
