package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.TransactionService;

public class SupplyTransactionService implements TransactionService {
    public void makeTransaction(String fruits, int number) {
        Storage.fruits.replace(fruits, Storage.fruits.get(fruits) + number);
    }
}
