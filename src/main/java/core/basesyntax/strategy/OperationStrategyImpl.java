package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<OperationType, OperationHandler> operations;

    public OperationStrategyImpl(Map<OperationType, OperationHandler> operations) {
        this.operations = operations;
    }

    @Override
    public OperationHandler get(Operation operation) {
        return operations.get(operation.getType());
    }
}
