package homework.strategy;

import homework.model.FruitTransaction;
import homework.strategy.handler.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationsMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> operationsMap) {
        this.operationsMap = operationsMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation type) {
        return operationsMap.get(type);
    }
}
