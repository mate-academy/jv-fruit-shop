package core.basesyntax.service;

import core.basesyntax.service.operationhandler.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {

    private Map<OperationTypes, OperationHandler> operationHandlersMap;

    public OperationStrategyImpl(Map<OperationTypes, OperationHandler> operationHandlersMap) {
        this.operationHandlersMap = operationHandlersMap;
    }

    @Override
    public OperationHandler getOperationHandler(OperationTypes operationType) {
        return operationHandlersMap.get(operationType);
    }
}
