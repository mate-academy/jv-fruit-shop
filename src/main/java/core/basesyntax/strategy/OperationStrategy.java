package core.basesyntax.strategy;

import core.basesyntax.record.Operation;
import core.basesyntax.service.RecordDataManipulation;

public interface OperationStrategy {
    RecordDataManipulation get(Operation operationType);
}
