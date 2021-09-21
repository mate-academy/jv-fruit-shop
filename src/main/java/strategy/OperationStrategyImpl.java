package strategy;

import java.util.Map;
import model.Fruit;
import service.handler.OperationHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<Fruit.TypeOperation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<Fruit.TypeOperation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(Fruit.TypeOperation type) {
        return operationHandlerMap.get(type);
    }
}
