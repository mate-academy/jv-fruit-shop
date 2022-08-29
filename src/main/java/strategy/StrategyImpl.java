package strategy;

import java.util.Map;
import model.Fruits;
import strategy.operations.OperationHandler;

public class StrategyImpl implements Strategy {
    private Map<Fruits.Operation, OperationHandler> operationHandlerMap;

    public StrategyImpl(Map<Fruits.Operation,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler getOperationTypeFruit(Fruits.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
