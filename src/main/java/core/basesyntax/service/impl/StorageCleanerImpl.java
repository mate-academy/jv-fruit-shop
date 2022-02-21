package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.StorageCleaner;

public class StorageCleanerImpl implements StorageCleaner {
    @Override
    public void clearStorage() {
        Storage.FRUIT_STORAGE.clear();
    }
}
