package core.basesyntax.strategy.impl;

import core.basesyntax.record.Operation;
import core.basesyntax.service.RecordDataManipulation;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private static Map<Operation, RecordDataManipulation> operations;

    public OperationStrategyImpl() {
    }

    public OperationStrategyImpl(Map<Operation, RecordDataManipulation> operations) {
        OperationStrategyImpl.operations = operations;
    }

    @Override
    public RecordDataManipulation get(Operation operationType) {
        return operations.get(operationType);
    }
}
