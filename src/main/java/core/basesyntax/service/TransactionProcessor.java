package core.basesyntax.service;

import java.util.List;

public interface TransactionProcessor {
    public void processTransactions(List<FruitTransaction> fruitTransactions);
}
