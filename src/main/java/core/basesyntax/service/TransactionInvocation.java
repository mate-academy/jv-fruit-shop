package core.basesyntax.service;

import core.basesyntax.operations.TransactionExecutor;
import java.util.List;
import java.util.Map;

public interface TransactionInvocation {
    void invokeTransaction(List<FruitTransaction> fruitTransactionList,
                           Map<FruitTransaction.Operation, TransactionExecutor> operationsMap);
}
