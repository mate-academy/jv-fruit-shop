package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.List;

public interface ProcessDataService {
    void processTransactions(List<FruitTransaction> transactions,
                             TransactionStrategy transactionStrategy);
}
