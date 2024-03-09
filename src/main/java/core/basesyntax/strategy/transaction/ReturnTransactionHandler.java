package core.basesyntax.strategy.transaction;

import core.basesyntax.model.Fruit;

public class ReturnTransactionHandler implements TransactionHandler {
    @Override
    public int getTransaction(Fruit fruit, int quantity) {
        return fruit.getQuantity() + quantity;
    }
}
