package core.basesyntax.strategy;

import core.basesyntax.operation.Operation;
import core.basesyntax.operation.OperationHandler;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<Operation, OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public Map.Entry<Operation, OperationHandler> getOperationHandler(Operation key) {
        return operationHandlers.entrySet().stream()
                .filter(entry -> entry.getKey().equals(key))
                .reduce((first, second) -> first)
                .orElseThrow();
    }
}
