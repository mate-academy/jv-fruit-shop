package core.basesyntax.strategy.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<Operation, OperationHandler> strategies;

    @Override
    public void provideStrategyList(Map<Operation, OperationHandler> strategies) {
        this.strategies = strategies;
    }

    @Override
    public OperationHandler get(String type) {
        return strategies.get(Operation.provideOperation(type));
    }
}
