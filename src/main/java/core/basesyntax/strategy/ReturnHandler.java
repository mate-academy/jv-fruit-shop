package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;

public class ReturnHandler implements TransactionHandler {
    @Override
    public int perform(int amount, Transaction transaction) {
        return amount + transaction.getAmount();
    }
}
