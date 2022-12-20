package core.basesyntax.service;

import core.basesyntax.operations.TransactionExecutor;
import java.util.List;
import java.util.Map;

public interface TransactionInvocation {
    void invokeTransaction(List<core.basesyntax.service.FruitTransaction> fruitTransactionList,
                           Map<core.basesyntax.service.FruitTransaction.Operation,
                                   TransactionExecutor> operationsMap);
}
