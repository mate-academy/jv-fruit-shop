package core.basesyntax.service;

import core.basesyntax.operations.TransactionExecutor;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, TransactionExecutor> operations;
    private FruitTransaction fruitTransaction;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, TransactionExecutor> operations,
                                 FruitTransaction fruitTransaction) {
        this.operations = operations;
        this.fruitTransaction = fruitTransaction;
    }

    @Override
    public void useOperation(FruitTransaction.Operation operation) {
        operations.get(operation).execute(fruitTransaction);
    }
}
