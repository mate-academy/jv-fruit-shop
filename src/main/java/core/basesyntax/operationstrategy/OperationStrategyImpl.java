package core.basesyntax.operationstrategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<Operation, OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    public void applyOperation(Operation operation, String fruit,
                               int quantity, Map<String, Integer> storage) {
        operationHandlers.get(operation).apply(fruit, quantity, storage);
    }
}
