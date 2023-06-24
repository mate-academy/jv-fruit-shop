package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int quantity = Storage.fruits.get(transaction.getFruit());
        if (quantity != 0) {
            Storage.fruits.put(transaction.getFruit(), transaction.getQuantity() + quantity);
        } else {
            Storage.fruits.put(transaction.getFruit(), transaction.getQuantity());
        }
    }
}
