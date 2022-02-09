package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationService> operationServiceMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationService> operationServiceMap) {
        this.operationServiceMap = operationServiceMap;
    }

    @Override
    public OperationService applyOperation(FruitTransaction.Operation operation) {
        return operationServiceMap.get(operation);
    }
}
