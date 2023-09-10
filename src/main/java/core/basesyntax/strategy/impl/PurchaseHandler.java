package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseHandler implements OperationHandler {

    @Override
    public void executeOperation(FruitTransaction transaction) {
        int currentQuantity = Storage.storage.get(transaction.getFruit());
        if (currentQuantity >= transaction.getQuantity()) {
            Storage.storage.put(transaction.getFruit(),
                    currentQuantity - transaction.getQuantity());
        } else {
            throw new RuntimeException("Quantity of fruits is nor enough for purchase");
        }
    }
}
