package core.basesyntax.strategy.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handler.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int currentQuantity = Storage.STORAGE
                .getOrDefault(fruit, 0);
        int transactionQuantity = transaction.getQuantity();
        if (transactionQuantity > currentQuantity) {
            throw new RuntimeException("Not enough " + fruit + " in stock."
                    + " The value is "
                    + currentQuantity + " and you want to purchase "
                    + transactionQuantity);
        }
        Storage.STORAGE.put(transaction.getFruit(),
                    currentQuantity - transactionQuantity);
    }
}
