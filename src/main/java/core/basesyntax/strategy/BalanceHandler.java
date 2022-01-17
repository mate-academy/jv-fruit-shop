package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;

public class BalanceHandler implements TransactionHandler {
    @Override
    public void perform(Fruit fruit, Transaction transaction) {
        fruit.setAmount(transaction.getAmount());
    }
}
