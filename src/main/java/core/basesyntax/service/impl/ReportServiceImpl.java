package core.basesyntax.service.impl;

import core.basesyntax.db.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String COLUMN_NAMES = "fruit,quantity";
    private StorageDao storageDao;

    public ReportServiceImpl(StorageDao storageDao) {
        if (storageDao == null) {
            throw new RuntimeException("StorageDao can't be null");
        }
        this.storageDao = storageDao;
    }

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder(COLUMN_NAMES);
        for (Fruit fruit : storageDao.getAll()) {
            report.append(System.lineSeparator()).append(fruit.getName()).append(',')
                    .append(fruit.getQuantity());
        }
        return report.toString();
    }
}
