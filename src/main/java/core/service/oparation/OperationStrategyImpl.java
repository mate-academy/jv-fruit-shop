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
        if (typeOperations.equals(TypeOperations.B.toString().toLowerCase())) {
            return operationHandlersMap.get(TypeOperations.B.toString().toLowerCase());
        }
        if (typeOperations.equals(TypeOperations.S.toString().toLowerCase())) {
            return operationHandlersMap.get(TypeOperations.S.toString().toLowerCase());
        }
        if (typeOperations.equals(TypeOperations.P.toString().toLowerCase())) {
            return operationHandlersMap.get(TypeOperations.P.toString().toLowerCase());
        }
        if (typeOperations.equals(TypeOperations.R.toString().toLowerCase())) {
            return operationHandlersMap.get(TypeOperations.R.toString().toLowerCase());
        }
        throw new RuntimeException("Incorrect operation!");
    }
}
