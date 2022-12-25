package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationStrategies;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationStrategies) {
        this.operationStrategies = operationStrategies;
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        return operationStrategies.get(operation);
    }
}
