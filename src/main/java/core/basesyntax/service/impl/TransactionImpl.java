package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StrategyController;
import core.basesyntax.service.Transaction;

public class TransactionImpl implements Transaction {
    @Override
    public void transaction(FruitTransaction fruitTransaction, StrategyController controller) {
        controller.getStrategy(fruitTransaction.getOperation())
                .calculate(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
