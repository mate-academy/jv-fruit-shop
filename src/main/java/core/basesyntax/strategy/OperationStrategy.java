package core.basesyntax.strategy;

import core.basesyntax.model.Record;

public interface OperationStrategy {
    void apply(Record record);
}
