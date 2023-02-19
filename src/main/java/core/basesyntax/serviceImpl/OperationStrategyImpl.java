package core.basesyntax.serviceImpl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.OperationStrategy;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> operationMap;

    public OperationStrategyImpl(Map<Operation, OperationHandler> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public OperationHandler get(Operation type) {
        return operationMap.get(type);
    }
}
