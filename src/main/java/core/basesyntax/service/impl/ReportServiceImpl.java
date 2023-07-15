package core.basesyntax.service.impl;

import core.basesyntax.db.StorageDao;
import core.basesyntax.service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String COLUMN_NAMES = "fruit,quantity";
    private StorageDao storageDao;

    public ReportServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder(COLUMN_NAMES);
        for (var mapEntry : storageDao.getAll()) {
            report.append(System.lineSeparator()).append(mapEntry.getKey()).append(',')
                    .append(mapEntry.getValue());
        }
        return report.toString();
    }
}
