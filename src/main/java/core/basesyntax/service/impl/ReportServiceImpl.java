package core.basesyntax.service.impl;

import core.basesyntax.db.StorageDao;
import core.basesyntax.service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String CSV_SEPARATOR = ",";

    @Override
    public String createReport(StorageDao storageDao) {
        StringBuilder stringBuilder = new StringBuilder();
        storageDao.getStorageStream()
                .forEach(s -> stringBuilder.append(
                        getLineFromStorage(s.getKey(), s.getValue())));
        return stringBuilder.toString();
    }

    private String getLineFromStorage(String key, Integer value) {
        return key + CSV_SEPARATOR + value + System.lineSeparator();
    }
}
