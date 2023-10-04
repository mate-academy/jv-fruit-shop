package strategy;

import java.util.Map;
import models.FruitTransaction;
import service.operation.OperationHandler;

public class StrategyImpl implements Strategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public StrategyImpl(Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
