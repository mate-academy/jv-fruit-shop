package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import java.util.Map;

public class OperationStrategy {

    private final Map<Operation, OperationHandler> operationStrategyMap;

    public OperationStrategy(Map<Operation, OperationHandler> operationStrategyMap) {
        this.operationStrategyMap = operationStrategyMap;
    }

    public OperationHandler getOperationHandler(Operation operation) {
        return operationStrategyMap.get(operation);
    }
}
