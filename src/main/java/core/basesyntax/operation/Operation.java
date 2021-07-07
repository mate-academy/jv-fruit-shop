package core.basesyntax.operation;

import core.basesyntax.service.Record;

public interface Operation {
    void transaction(Record record);
}
