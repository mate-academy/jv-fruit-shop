package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.TransactionHandler;

public class ReturnTransactionHandler implements TransactionHandler {
    @Override
    public int getAmount(int amount) {
        return amount;
    }
}
