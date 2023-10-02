package core.basesyntax.service;

import java.util.List;
import core.basesyntax.model.FruitTransaction;

public interface TransactionExecutor {
    void executeTransaction(List<FruitTransaction> transactionList);
}
