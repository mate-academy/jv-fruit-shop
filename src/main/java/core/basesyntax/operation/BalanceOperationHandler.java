package core.basesyntax.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void applyTransactionToStorage(FruitTransaction fruitTransaction) {
        int amount = fruitTransaction.getAmount();
        if (amount < 0) {
            throw new RuntimeException("Balance can't be less than 0");
        }
        Storage.fruits.put(fruitTransaction.getFruit(), amount);
    }
}
