package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.TransactionHandler;

public class PurchaseTransactionHandler implements TransactionHandler {
    @Override
    public int getAmount(int amount) {
        if (amount > 0) {
            return amount * -1;
        }
        return amount;
    }
}
