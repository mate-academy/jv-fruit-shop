package core.basesyntax.transactions;

import java.util.List;

public interface ProcessingAllTransactions {
    void processAllTransactions(List<FruitTransaction> transactions);
}
