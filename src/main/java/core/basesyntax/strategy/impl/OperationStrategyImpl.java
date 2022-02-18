package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationServiceMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationServiceMap) {
        this.operationServiceMap = operationServiceMap;
    }

    @Override
    public OperationHandler applyOperation(FruitTransaction.Operation operation) {
        return operationServiceMap.get(operation);
    }
}
