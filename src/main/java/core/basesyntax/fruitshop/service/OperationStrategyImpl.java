package core.basesyntax.fruitshop.service;

import core.basesyntax.fruitshop.model.OperationType;
import core.basesyntax.fruitshop.service.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<OperationType, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<OperationType, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(OperationType operationType) {
        return operationHandlerMap.get(operationType);
    }
}
