package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.operation.FruitOperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, FruitOperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            FruitOperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public FruitOperationHandler get(FruitTransaction.Operation type) {
        try {
            return operationHandlerMap.get(type);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Illegal operation type " + type);
        }
    }
}
