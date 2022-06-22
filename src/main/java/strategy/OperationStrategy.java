package strategy;

import java.util.Map;
import model.Operation;

public class OperationStrategy {
    private static Map<Operation, OperationHandler> operationHandler = null;

    public static void setOperationHandler(Map<Operation, OperationHandler> operationHandler) {
        OperationStrategy.operationHandler = operationHandler;
    }

    public static OperationHandler getOperationServiceStrategy(String operation) {
        return operationHandler.get(Operation.getOperationByName(operation));
    }
}
