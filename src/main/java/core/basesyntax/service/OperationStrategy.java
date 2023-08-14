package core.basesyntax.service;

import core.basesyntax.model.Record;
import core.basesyntax.service.operations.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(Record.OperationType operationType);
}
