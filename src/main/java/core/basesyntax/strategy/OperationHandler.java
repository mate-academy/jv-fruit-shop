package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public interface OperationHandler {
    void apply(String fruit, int quantity, Storage storage);
}
