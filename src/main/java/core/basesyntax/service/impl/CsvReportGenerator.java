package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;
import java.util.Map.Entry;

public class CsvReportGenerator implements ReportGenerator {
    private static final String REPORT_FIRST_LINE = "fruit,quantity";
    private static final String COMA = ",";
    private final StorageDao storageDao;

    public CsvReportGenerator(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String generateReport() {
        Map<String, Integer> storageMap = storageDao.getStorageState();
        StringBuilder stringBuilder = new StringBuilder(REPORT_FIRST_LINE + "\n");
        for (Entry<String, Integer> entry : storageMap.entrySet()) {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(entry.getKey()).append(COMA).append(entry.getValue());
        }
        return stringBuilder.toString();
    }
}
