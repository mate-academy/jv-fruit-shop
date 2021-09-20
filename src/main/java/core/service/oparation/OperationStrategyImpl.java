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
        for (TypeOperations operation : enumOperationArray) {
            if (operation.get().equals(typeOperations)) {
                return operationHandlersMap.get(operation.get());
            }
        }
        return null;
    }
}
