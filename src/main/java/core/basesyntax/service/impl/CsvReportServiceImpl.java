package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.service.ReportService;
import java.util.stream.Collectors;

public class CsvReportServiceImpl implements ReportService {
    private static final String DATA_SEPARATOR = ",";
    private static final String HEADING = "fruit,quantity";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private final StorageDao storageDao;

    public CsvReportServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String createReport() {
        return HEADING + storageDao.getAllData()
                .entrySet()
                .stream()
                .map(entry -> LINE_SEPARATOR
                        + entry.getKey()
                        + DATA_SEPARATOR
                        + entry.getValue())
                .collect(Collectors.joining());
    }
}
