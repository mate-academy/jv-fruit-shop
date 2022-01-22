package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;

public class BalanceHandler implements TransactionHandler {
    @Override
    public int perform(int amount, Transaction transaction) {
        return transaction.getAmount();
    }
}
