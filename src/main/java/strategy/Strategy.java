package strategy;

import java.util.Map;
import model.FruitTransaction;
import operations.OperationHandler;

public class Strategy implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public Strategy(Map<FruitTransaction.Operation, OperationHandler>
                                         operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    public OperationHandler get(FruitTransaction.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
