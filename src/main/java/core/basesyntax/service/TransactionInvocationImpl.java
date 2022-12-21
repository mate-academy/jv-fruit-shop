package core.basesyntax.service;

import core.basesyntax.operations.TransactionExecutor;
import java.util.List;
import java.util.Map;

public class TransactionInvocationImpl implements TransactionInvocation {
    @Override
    public void invokeTransaction(List<FruitTransaction> fruitTransactionList,
                                  Map<FruitTransaction.Operation,
                                          TransactionExecutor> operationsMap) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            new OperationStrategyImpl(operationsMap, fruitTransaction)
                    .getOperation(fruitTransaction.getOperation());
        }
    }
}
