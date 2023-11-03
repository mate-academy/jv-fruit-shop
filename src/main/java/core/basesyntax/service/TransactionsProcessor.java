package core.basesyntax.service;

import core.basesyntax.transaction.FruitTransaction;
import java.util.List;

public interface TransactionsProcessor {
    void processTransactions(List<FruitTransaction> fruitTransactionList);
}
