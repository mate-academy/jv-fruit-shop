package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationStrategyMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationStrategyMap) {
        this.operationStrategyMap = operationStrategyMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return operationStrategyMap.get(operation);
    }
}
