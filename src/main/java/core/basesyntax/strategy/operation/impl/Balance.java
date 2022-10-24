package core.basesyntax.strategy.operation.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.operation.Operation;

public class Balance implements Operation {
    @Override
    public void apply(Transaction transaction) {
        FruitService fruitService = new FruitService();
        fruitService.processIncomingTransaction(transaction);
    }
}
