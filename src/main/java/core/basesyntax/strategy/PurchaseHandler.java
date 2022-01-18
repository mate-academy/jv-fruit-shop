package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;

public class PurchaseHandler implements TransactionHandler {
    @Override
    public int perform(int amount, Transaction transaction) {
        return amount - transaction.getAmount();
    }
}
