package core.service.oparation;

import core.model.TypeOperations;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<String, OperationHandler> operationHandlersMap;

    public OperationStrategyImpl(Map<String, OperationHandler> operationHandlersMap) {
        this.operationHandlersMap = operationHandlersMap;
    }

    @Override
    public OperationHandler get(String typeOperations) {
        TypeOperations[] enumOperationArray = TypeOperations.values();
        OperationHandler operationHandler = null;
        for (TypeOperations operation : enumOperationArray) {
            if (operation.get().equals(typeOperations)) {
                operationHandler = operationHandlersMap.get(operation.get());
                break;
            }
        }
        return operationHandler;
    }
}
