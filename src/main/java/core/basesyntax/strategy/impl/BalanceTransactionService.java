package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.TransactionService;

public class BalanceTransactionService implements TransactionService {
    @Override
    public void makeTransaction(String fruits, int number) {
        Storage.fruits.put(fruits, number);
    }
}
