package core.basesyntax.transaction;

import java.util.List;

public interface TransactionProcessor {
    public void processTransactions(List<FruitTransaction> fruitTransactions);
}
