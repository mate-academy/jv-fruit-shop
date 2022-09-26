package core.basesyntax.service.report;

import core.basesyntax.dao.StorageDao;
import java.util.Map;

public class CsvReportServiceImpl implements ReportService {
    private static final String REPORT_HEADER = "fruit,quantity";
    private final StorageDao storageDao;

    public CsvReportServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(REPORT_HEADER)
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : storageDao.getAllFruitsFromStorage().entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
