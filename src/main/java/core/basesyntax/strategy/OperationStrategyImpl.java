package core.basesyntax.strategy;

import core.basesyntax.exceptions.OperationNotFoundException;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.handler.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> strategy;

    public OperationStrategyImpl(Map<Operation, OperationHandler> strategy) {
        this.strategy = strategy;
    }

    @Override
    public OperationHandler getOperationHandler(Operation operation) {
        if (strategy.get(operation) == null) {
            throw new OperationNotFoundException("Strategy with for operation: "
                    + operation + " not found");
        }
        return strategy.get(operation);
    }
}
