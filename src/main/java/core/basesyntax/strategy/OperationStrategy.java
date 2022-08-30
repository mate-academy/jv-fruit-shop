package core.basesyntax.strategy;

import java.util.Map;

public class OperationStrategy {
    private final Map<String, OperationHandler> operations;

    public OperationStrategy(Map<String, OperationHandler> operations) {
        this.operations = operations;
    }

    public OperationHandler getByOperation(String operation) {
        return operations.get(operation);
    }
}
