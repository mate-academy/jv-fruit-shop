package core.basesyntax.service.impl;

import core.basesyntax.model.FruitOperation;
import core.basesyntax.service.OperationExecutor;
import core.basesyntax.strategy.Operation;
import java.util.List;
import java.util.Map;

public class OperationExecutorImpl implements OperationExecutor {
    private final Map<FruitOperation.Operation, Operation> operationsHandlers;

    public OperationExecutorImpl(Map<FruitOperation.Operation, Operation> operationsHandlers) {
        this.operationsHandlers = operationsHandlers;
    }

    @Override
    public void proceedAll(List<FruitOperation> commands) {
        Operation currentOperation;
        for (FruitOperation fruitOperation : commands) {
            currentOperation = operationsHandlers.get(fruitOperation.getOperation());
            if (currentOperation == null) {
                throw new RuntimeException("No handler found for operation: "
                        + fruitOperation.getOperation());
            }
            currentOperation.proceed(fruitOperation);
        }
    }
}
