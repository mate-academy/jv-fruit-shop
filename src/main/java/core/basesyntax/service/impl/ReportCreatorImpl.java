package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.service.ReportCreator;

public class ReportCreatorImpl implements ReportCreator {
    public static final String HEADER = "fruit,quantity";
    public static final String DELIMITER = ",";
    private final StorageDao storageDao;

    public ReportCreatorImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String createReport() {
        StringBuilder result = new StringBuilder(HEADER + System.lineSeparator());
        for (var entry : storageDao.getAll().entrySet()) {
            result
                    .append(entry.getKey())
                    .append(DELIMITER)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return result.toString();
    }
}
