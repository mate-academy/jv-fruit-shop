package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.Operation;

public class BalanceOperation implements Operation {

    @Override
    public void performOperation(FruitTransaction fruitTransaction) {
        Storage.getFruits().put(fruitTransaction.getFruitName(), fruitTransaction.getAmount());
    }
}
