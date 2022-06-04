package core.basesyntax.strategy.action;

import core.basesyntax.model.Record;

public interface ActionHandler {
    void runAction(Record record);
}
