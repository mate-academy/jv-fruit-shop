package core.basesyntax.strategy.impl;

import core.basesyntax.database.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void applyTransactionToStorage(FruitTransaction fruitTransaction) {
        int currQuantity = fruitTransaction.getQuantity();
        Integer currentBalance = Storage.fruitsStorage.get(fruitTransaction.getFruit());
        if (currQuantity < 0) {
            throw new RuntimeException("Quantity of purchased item must be greater than zero!");
        }
        if (currentBalance < currQuantity) {
            throw new RuntimeException("Product is not enough to complete current purchase!");
        }
        Storage.fruitsStorage.put(fruitTransaction.getFruit(),
                Storage.fruitsStorage.get(fruitTransaction.getFruit()) - currQuantity);
    }
}
