package core.basesyntax.transaction;

import java.util.Map;
import java.util.function.Predicate;

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
