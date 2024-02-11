package core.basesyntax.service.impl;

import core.basesyntax.service.TransactionService;

public class BalanceTransactionService implements TransactionService {
    @Override
    public int executeTransaction(int quantity, int count) {
        return quantity + count;
    }
}
