package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionExecutor {
    void executeTransaction(List<FruitTransaction> transactionList);
}
