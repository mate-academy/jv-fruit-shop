package strategy;

import java.util.Map;
import model.FruitTransaction;
import strategy.handler.OperationHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return operationMap.get(operation);
    }
}
