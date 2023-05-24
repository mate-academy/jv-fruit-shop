package core.basesyntax.strategy;

import core.basesyntax.model.fruit.Record;

public interface OperationHandler {
    void perform(Record record);
}
