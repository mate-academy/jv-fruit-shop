package strategy.strategies;

import java.util.Map;
import service.Handler.service.OperationHandler;
import model.FruitTransaction;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation,
            OperationHandler> operationOperationHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationOperationHandlerMap) {
        this.operationOperationHandlerMap = operationOperationHandlerMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
       return operationOperationHandlerMap.get(operation);
    }
}
