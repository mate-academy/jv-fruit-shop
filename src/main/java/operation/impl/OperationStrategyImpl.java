package operation.impl;

import java.util.Map;
import model.Operation;
import operation.OperationHandler;
import operation.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> operations;

    public OperationStrategyImpl(Map<Operation, OperationHandler> operations) {
        this.operations = operations;
    }

    @Override
    public OperationHandler get(Operation operationType) {
        return operations.get(operationType);
    }
}
