package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public interface OperationHandler {
    Storage storage = new Storage();
    void update(String key, Integer value);
}
