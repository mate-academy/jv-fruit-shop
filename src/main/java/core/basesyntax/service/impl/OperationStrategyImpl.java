package core.basesyntax.service.impl;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationStrategies;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationStrategies) {
        this.operationStrategies = operationStrategies;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return operationStrategies.get(operation);
    }
}
