package operation.impl;

import java.util.Map;
import operation.OperationHandler;
import operation.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<String, OperationHandler> operations;

    public OperationStrategyImpl(Map<String, OperationHandler> operations) {
        this.operations = operations;
    }

    @Override
    public OperationHandler get(String operationType) {
        return operations.get(operationType);
    }
}
