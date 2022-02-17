package core.basesyntax.service.strategy;

import core.basesyntax.service.DataProcessorImpl;

public interface OperationStrategy {
    OperationHandler get(DataProcessorImpl.OperationType operationType);
}
