package core.basesyntax.service.report;

import core.basesyntax.dao.StorageDao;

public class CsvReportServiceImpl implements ReportService {
    private static final String REPORT_HEADER = "fruit,quantity";
    private final StorageDao storageDao;

    public CsvReportServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(REPORT_HEADER)
                .append(System.lineSeparator())
                .append(storageDao.getAllFruitsFromStorage())
                .toString();
    }
}
