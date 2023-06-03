package fruitshop.strategy;

import fruitshop.model.FruitTransaction;
import fruitshop.strategy.impl.OperationStrategy;

import java.util.Map;

public class HandleStrategyImpl implements HandleStrategy {
    private Map<FruitTransaction.Operation, OperationStrategy> operationOperationStrategyMap;

    public HandleStrategyImpl(Map<FruitTransaction.Operation,
            OperationStrategy> operationOperationStrategyMap) {
        this.operationOperationStrategyMap = operationOperationStrategyMap;
    }

    @Override
    public OperationStrategy getStrategy(FruitTransaction.Operation operation) {
        return operationOperationStrategyMap.get(operation);
    }
}
