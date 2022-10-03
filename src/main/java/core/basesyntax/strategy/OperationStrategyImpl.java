package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> operations;

    public OperationStrategyImpl(final Map<Operation, OperationHandler> operations) {
        this.operations = operations;
    }

    @Override
    public OperationHandler get(final Operation operation) {
        return operations.get(operation);
    }
}
