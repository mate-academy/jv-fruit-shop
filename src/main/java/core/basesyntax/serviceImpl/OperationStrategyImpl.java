package core.basesyntax.serviceImpl;

import core.basesyntax.model.Operation;
import core.basesyntax.serviceOperate.OperationHandlerService;
import core.basesyntax.serviceOperate.OperationStrategy;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<Operation, OperationHandlerService> operationHandlerServiceMap;

    public OperationStrategyImpl(Map<Operation, OperationHandlerService> operationHandlerServiceMap) {
        this.operationHandlerServiceMap = operationHandlerServiceMap;
    }

    @Override
    public OperationHandlerService getOperationHandler(Operation operation) {
        return operationHandlerServiceMap.get(operation);
    }
}
