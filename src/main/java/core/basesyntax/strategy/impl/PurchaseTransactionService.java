package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.TransactionService;

public class PurchaseTransactionService implements TransactionService {
    public void makeTransaction(String fruits, int number) {
        if (Storage.fruits.get(fruits) - number < 0) {
            throw new RuntimeException("Transaction cannot be completed: not enough fruit");
        }
        Storage.fruits.replace(fruits, Storage.fruits.get(fruits) - number);
    }
}
