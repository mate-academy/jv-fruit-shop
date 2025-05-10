package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionProcessorService {
    void processTransactions(List<FruitTransaction> transactions);
}
