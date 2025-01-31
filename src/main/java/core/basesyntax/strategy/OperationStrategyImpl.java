package core.basesyntax.strategy;

import core.basesyntax.FruitTransaction;
import core.basesyntax.strategy.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(
            Map<FruitTransaction.Operation, OperationHandler> operationHandlers
    ) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public OperationHandler getOperationHandler(FruitTransaction.Operation operation) {
        if (operationHandlers.get(operation) == null) {
            throw new IllegalArgumentException("Unknown operation: " + operation);
        }
        return operationHandlers.get(operation);
    }
}
