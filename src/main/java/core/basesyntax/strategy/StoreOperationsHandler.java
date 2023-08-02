package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public interface StoreOperationsHandler {
    void applyOperation(Storage storage, String product, int quantity);
}
