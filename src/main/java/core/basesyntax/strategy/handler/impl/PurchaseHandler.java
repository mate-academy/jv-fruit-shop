package core.basesyntax.strategy.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handler.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int fruitQuantity = Storage.get(transaction.getFruit());
        if (transaction.getQuantity() <= fruitQuantity) {
            Storage.put(transaction.getFruit(), fruitQuantity - transaction.getQuantity());
        }
    }
}
