package core.basesyntax.service.operation.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<Operation, OperationHandler> strategies;

    public OperationStrategyImpl(Map<Operation, OperationHandler> strategies) {
        this.strategies = strategies;
    }

    @Override
    public OperationHandler get(String typeOfStrategy) {
        return strategies.get(Operation.getOperation(typeOfStrategy));
    }
}
