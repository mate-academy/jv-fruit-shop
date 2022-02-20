package core.basesyntax.service;

import core.basesyntax.db.Storage;

public class StorageCleanerImpl implements StorageCleaner {
    @Override
    public void clearStorage() {
        Storage.FRUIT_STORAGE.clear();
    }
}
