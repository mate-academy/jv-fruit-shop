package core.basesyntax.impl;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.util.Operation;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> operationTypeMap;

    public OperationStrategyImpl(Map<Operation, OperationHandler> operationTypeMap) {
        this.operationTypeMap = operationTypeMap;
    }

    @Override
    public OperationHandler getOperationStrategy(Operation operation) {
        return operationTypeMap.get(operation);
    }
}
