package core.basesyntax.strategy;

import core.basesyntax.enums.Operation;
import core.basesyntax.strategy.impl.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<Operation, OperationHandler> operationServiceMap;

    public OperationStrategyImpl(Map<Operation, OperationHandler> operationServiceMap) {
        this.operationServiceMap = operationServiceMap;
    }

    @Override
    public OperationHandler get(Operation operation) {
        return operationServiceMap.get(operation);
    }
}
