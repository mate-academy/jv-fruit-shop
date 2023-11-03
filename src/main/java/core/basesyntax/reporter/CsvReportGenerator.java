package core.basesyntax.reporter;

import core.basesyntax.dao.StorageDao;
import java.util.Map;

public class CsvReportGenerator implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String FRUIT_AND_QUANTITY_SEPARATOR = ",";

    @Override
    public String createReport(StorageDao storageDao) {
        Map<String, Integer> storage = storageDao.getStorage();
        StringBuilder report = new StringBuilder();
        report.append(HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            report.append(entry.getKey()).append(FRUIT_AND_QUANTITY_SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
