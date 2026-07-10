package core.basesyntax;

import java.util.Map;
import java.util.Optional;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public OperationHandler getOperationHandler(FruitTransaction.Operation operation) {
        return Optional.ofNullable(operationHandlers.get(operation))
                .orElseThrow(() -> new RuntimeException("No handler for operation: " + operation));
    }
}
