package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.TransactionStrategy;

public class SupplyTransactionStrategy implements TransactionStrategy {
    @Override
    public void processData(FruitTransaction transaction) {
        int currentQuantity = fruitDao.getQuantity(transaction.getFruit());
        fruitDao.setQuantity(
                transaction.getFruit(),
                currentQuantity + transaction.getQuantity()
        );
    }
}
