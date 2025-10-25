package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String WORD_SEPARATOR = ",";
    private final StorageDao storageDao;

    public ReportGeneratorImpl(StorageDao storageDao) {
        if (storageDao == null) {
            throw new RuntimeException("Cannot access to storage dao: parameter is null");
        }
        this.storageDao = storageDao;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder(REPORT_HEADER);
        report.append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : storageDao.getAllFruitsQuantities().entrySet()) {
            report.append(entry.getKey())
                    .append(WORD_SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
