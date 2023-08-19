package core.basesyntax.service.strategy.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> operationStarategyMap;

    public OperationStrategyImpl(Map<Operation, OperationHandler> operationStarategyMap) {
        this.operationStarategyMap = operationStarategyMap;
    }

    @Override
    public OperationHandler processOperation(Operation operation) {
        return operationStarategyMap.get(operation);
    }
}
