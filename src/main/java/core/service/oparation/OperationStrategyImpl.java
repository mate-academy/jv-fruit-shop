package core.service.oparation;

import core.model.TypeOperations;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<String, OperationHandler> operationHandlersMap;

    public OperationStrategyImpl(Map<String, OperationHandler> operationHandlersMap) {
        this.operationHandlersMap = operationHandlersMap;
    }

    @Override
    public OperationHandler get(TypeOperations typeOperations) {
        return operationHandlersMap.get(typeOperations.get());
    }
}
