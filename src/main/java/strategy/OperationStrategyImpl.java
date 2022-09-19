package strategy;

import java.util.Map;
import model.FruitTransaction;
import strategy.operationhandlers.OperationHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation,OperationHandler> operationMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return operationMap.get(operation);
    }
}
