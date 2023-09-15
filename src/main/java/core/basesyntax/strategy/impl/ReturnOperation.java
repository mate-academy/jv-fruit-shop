package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.Operation;

public class ReturnOperation implements Operation {

    @Override
    public void performOperation(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruitName();
        int currentAmount = Storage.getFruits().get(fruitTransaction.getFruitName());
        int transactionAmount = fruitTransaction.getAmount();
        Storage.getFruits().put(fruitName, currentAmount + transactionAmount);
    }
}
