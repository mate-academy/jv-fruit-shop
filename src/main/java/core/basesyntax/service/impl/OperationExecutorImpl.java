package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationExecutor;
import core.basesyntax.strategy.Operation;
import java.util.List;
import java.util.Map;

public class OperationExecutorImpl implements OperationExecutor {
    private final Map<FruitTransaction.Operation, Operation> operationsHandlers;

    public OperationExecutorImpl(Map<FruitTransaction.Operation, Operation> operationsHandlers) {
        this.operationsHandlers = operationsHandlers;
    }

    @Override
    public void proceedAll(List<FruitTransaction> commands) {
        Operation currentOperation;
        for (FruitTransaction fruitTransaction : commands) {
            currentOperation = operationsHandlers.get(fruitTransaction.getOperation());
            if (currentOperation == null) {
                throw new RuntimeException("No handler found for operation: "
                        + fruitTransaction.getOperation());
            }
            currentOperation.proceed(fruitTransaction);
        }
    }
}
