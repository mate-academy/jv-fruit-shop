package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionPerformer {
    void performTransactions(List<FruitTransaction> transactions);
}
