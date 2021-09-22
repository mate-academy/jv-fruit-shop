package strategy;

import java.util.Map;
import model.Fruit;
import service.operation.Calculator;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<Fruit.OperationType, Calculator> operationHandlerMap;

    public OperationStrategyImpl(Map<Fruit.OperationType, Calculator> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public Calculator get(Fruit.OperationType type) {
        return operationHandlerMap.get(type);
    }
}
