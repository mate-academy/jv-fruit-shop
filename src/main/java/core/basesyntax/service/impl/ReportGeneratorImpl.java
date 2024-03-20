package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String COMMA_SEPARATOR = ",";

    private final StorageDao storageDao;

    public ReportGeneratorImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder(REPORT_HEADER);
        storageDao.getStorage().entrySet().stream()
                .map(entry -> entry.getKey() + COMMA_SEPARATOR + entry.getValue())
                .forEach(s -> report.append(System.lineSeparator()).append(s));
        return report.toString();
    }
}
