package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionService {
    void executeTransaction(FruitTransaction fruitTransaction);

    default void executeTransactions(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            this.executeTransaction(fruitTransaction);
        }
    }
}
