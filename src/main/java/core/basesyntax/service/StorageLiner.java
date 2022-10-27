package core.basesyntax.service;

import core.basesyntax.db.StorageDao;

public interface StorageLiner {
    String getLines(StorageDao storageDao);
}
