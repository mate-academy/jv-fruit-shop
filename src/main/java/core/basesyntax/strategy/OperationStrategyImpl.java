package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> operationMap;

    public OperationStrategyImpl(Map<Operation, OperationHandler> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public OperationHandler get(Operation operationType) {
        return operationMap.get(operationType);
    }
}
