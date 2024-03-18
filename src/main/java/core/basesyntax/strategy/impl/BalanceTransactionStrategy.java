package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.TransactionStrategy;

public class BalanceTransactionStrategy implements TransactionStrategy {
    @Override
    public void processData(FruitTransaction transaction) {
        fruitDao.setQuantity(
                transaction.getFruit(),
                transaction.getQuantity()
        );
    }
}
