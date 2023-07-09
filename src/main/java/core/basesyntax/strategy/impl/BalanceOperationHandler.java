package core.basesyntax.strategy.impl;

import core.basesyntax.database.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void applyTransactionToStorage(FruitTransaction fruitTransaction) {
        int currQuantity = fruitTransaction.getQuantity();
        if (currQuantity < 0) {
            throw new RuntimeException("Quantity of goods on the balance cannot be less than zero!");
        }
        Storage.fruitsStorage.put(fruitTransaction.getFruit(), currQuantity);
    }
}
