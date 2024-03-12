package strategy;

import java.util.Map;
import model.FruitTransaction;
import strategy.activities.OperationHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> activitiesHandlerMap) {
        this.operationHandlerMap = activitiesHandlerMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
