package core.basesyntax.strategy;

import core.basesyntax.model.StorageTransaction;

public interface StoreActivities {
    void doActivity(StorageTransaction transaction);
}
