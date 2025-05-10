package strategy;

import java.util.Map;
import model.FruitTransaction;
import strategy.operation.OperationHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler getHandler(FruitTransaction fruitTransaction) {
        return operationHandlerMap.get(fruitTransaction.getOperation());
    }
}
