package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import java.util.Map;

public class OperationStrategy {
    private final Map<Operation, OperationHandler> operationsMap;

    public OperationStrategy(Map<Operation, OperationHandler> operationsMap) {
        this.operationsMap = operationsMap;
    }

    public OperationHandler getOperationHandler(Operation operation) {
        return operationsMap.get(operation);
    }
}
