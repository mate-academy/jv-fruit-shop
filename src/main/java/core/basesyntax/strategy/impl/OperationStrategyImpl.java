package core.basesyntax.strategy.impl;

import core.basesyntax.record.Operation;
import core.basesyntax.service.DataOperation;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, DataOperation> operations;

    public OperationStrategyImpl(Map<Operation, DataOperation> operations) {
        this.operations = operations;
    }

    @Override
    public DataOperation get(Operation operationType) {
        return operations.get(operationType);
    }
}
