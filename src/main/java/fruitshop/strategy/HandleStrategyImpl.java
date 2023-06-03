package fruitshop.strategy;

import fruitshop.model.FruitTransaction;
import fruitshop.strategy.handler.OperationHandler;
import java.util.Map;

public class HandleStrategyImpl implements HandleStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationOperationStrategyMap;

    public HandleStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationOperationStrategyMap) {
        this.operationOperationStrategyMap = operationOperationStrategyMap;
    }

    @Override
    public OperationHandler getStrategy(FruitTransaction.Operation operation) {
        return operationOperationStrategyMap.get(operation);
    }
}
