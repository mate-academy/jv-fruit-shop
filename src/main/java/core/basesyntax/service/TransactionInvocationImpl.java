package core.basesyntax.service;

import core.basesyntax.operations.FruitTransaction;

import java.util.List;
import java.util.Map;

public class TransactionInvocationImpl implements TransactionInvocation {
    @Override
    public void invokeTransaction(List<core.basesyntax.service.FruitTransaction> fruitTransactionList, Map<core.basesyntax.service.FruitTransaction.Operation, FruitTransaction> operationsMap) {
        for (core.basesyntax.service.FruitTransaction fruitTransaction : fruitTransactionList) {
            new OperationStrategyImpl(operationsMap, fruitTransaction)
                    .getOperation(fruitTransaction.getOperation());
        }
    }
}
