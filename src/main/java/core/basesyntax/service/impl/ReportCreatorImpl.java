package core.basesyntax.service.impl;

import core.basesyntax.db.StorageDao;
import core.basesyntax.service.ReportCreator;

public class ReportCreatorImpl implements ReportCreator {
    public static final int MIN_VALUE = 0;
    public static final String WORD_SEPARATOR = ",";
    public static final String LINE_SEPARATOR = "\n";
    private final StorageDao storageDao;

    public ReportCreatorImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder("fruit,quantity");
        storageDao.getAll().entrySet()
                .forEach(fruit -> {
                    if (fruit.getValue() < MIN_VALUE) {
                        throw new RuntimeException("Balance should be positive: "
                                + fruit);
                    }
                });
        storageDao.getAll().forEach((key, value) -> {
            report.append(LINE_SEPARATOR);
            report.append(key);
            report.append(WORD_SEPARATOR);
            report.append(value);
        });
        return report.toString();
    }
}
