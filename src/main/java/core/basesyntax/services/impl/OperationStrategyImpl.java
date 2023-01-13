package core.basesyntax.services.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.OperationHandler;
import core.basesyntax.services.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationStrategies;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationStrategies) {
        this.operationStrategies = operationStrategies;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return operationStrategies.get(operation);
    }
}
