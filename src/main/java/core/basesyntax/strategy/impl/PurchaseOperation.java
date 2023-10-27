package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.Operation;

public class PurchaseOperation implements Operation {
    @Override
    public void performOperation(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruitName();
        int currentAmount = Storage.getFruits().get(fruitTransaction.getFruitName());
        int transactionAmount = fruitTransaction.getAmount();
        if (currentAmount > fruitTransaction.getAmount()) {
            Storage.getFruits().put(fruitName, currentAmount - transactionAmount);
        } else {
            throw new RuntimeException("This operation is impossible. "
                    + "We don`t have enough fruits: " + fruitName);
        }
    }
}
