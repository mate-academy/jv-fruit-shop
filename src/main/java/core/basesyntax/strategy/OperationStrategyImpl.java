package core.basesyntax.strategy;

import core.basesyntax.dto.Operation;
import core.basesyntax.strategy.handler.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> strategies;

    public OperationStrategyImpl(Map<Operation, OperationHandler> strategies) {
        this.strategies = strategies;
    }

    @Override
    public OperationHandler findHandler(Operation operation) {
        return strategies.get(operation);
    }
}
