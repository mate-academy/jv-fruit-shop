package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public interface StoreOperationsHandler {
    void operation(Storage storage, String product, int quantity);
}
