package core.basesyntax.strategy.transaction;

import core.basesyntax.model.Fruit;

public class BalanceTransactionHandler implements TransactionHandler {

    @Override
    public int getTransaction(Fruit fruit, int quantity) {
        return quantity;
    }
}
