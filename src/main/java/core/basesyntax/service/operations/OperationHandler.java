package core.basesyntax.service.operations;

import core.basesyntax.model.Record;

public interface OperationHandler {
    Integer updateValue(Record record, Integer oldValue);
}
