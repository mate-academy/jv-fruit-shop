package fruitshop.strategy;

import fruitshop.model.FruitTransaction;
import fruitshop.strategy.handler.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationOperationStrategyMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationOperationStrategyMap) {
        this.operationOperationStrategyMap = operationOperationStrategyMap;
    }

    @Override
    public OperationHandler getStrategy(FruitTransaction.Operation operation) {
        return operationOperationStrategyMap.get(operation);
    }
}
