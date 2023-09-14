package core.basesyntax.strategy.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handler.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    public static final int DEFAULT_QUANTITY = 0;

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int currentQuantity = Storage.storage
                .getOrDefault(fruit, DEFAULT_QUANTITY);
        int transactionQuantity = fruitTransaction.getQuantity();

        if (transactionQuantity > currentQuantity) {
            throw new RuntimeException("Not enough " + fruit
                    + " in stock. "
                    + "The value is " + currentQuantity
                    + " and you want to purchase " + transactionQuantity
            );
        }
        Storage.storage.put(fruit,
                currentQuantity - transactionQuantity);
    }
}
