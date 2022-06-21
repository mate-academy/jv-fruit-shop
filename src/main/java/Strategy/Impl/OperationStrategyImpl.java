package Strategy.Impl;

import Strategy.OperationStrategy;
import model.FruitTransaction;
import service.FruitHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, FruitHandler> operationFruitHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, FruitHandler> operationFruitHandlerMap) {
        this.operationFruitHandlerMap = operationFruitHandlerMap;
    }

    @Override
    public FruitHandler get(FruitTransaction.Operation operation) {
        return operationFruitHandlerMap.get(operation);
    }
}
