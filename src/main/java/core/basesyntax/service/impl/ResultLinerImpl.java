package core.basesyntax.service.impl;

import core.basesyntax.db.StorageDao;
import core.basesyntax.service.StorageLiner;

public class ResultLinerImpl implements StorageLiner {
    private static final String CSV_SEPARATOR = ",";

    @Override
    public String getLines(StorageDao storageDao) {
        StringBuilder stringBuilder = new StringBuilder();
        storageDao.getStorageStream()
                .forEach(s -> stringBuilder.append(
                        getLineFromStorage(s.getKey(), storageDao)));
        return stringBuilder.toString();
    }

    private String getLineFromStorage(String key, StorageDao storageDao) {
        return key + CSV_SEPARATOR + storageDao.getValue(key) + System.lineSeparator();
    }
}
