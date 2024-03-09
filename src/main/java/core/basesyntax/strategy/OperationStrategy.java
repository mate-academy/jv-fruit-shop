package core.basesyntax.strategy;

import core.basesyntax.record.Operation;
import core.basesyntax.service.DataOperation;

public interface OperationStrategy {
    DataOperation get(Operation operationType);
}
