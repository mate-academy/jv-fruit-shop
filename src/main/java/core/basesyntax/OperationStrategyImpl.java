package core.basesyntax;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    public OperationHandler getOperationHandler(FruitTransaction.Operation operation) {
        return operationHandlers.get(operation);
    }
}
