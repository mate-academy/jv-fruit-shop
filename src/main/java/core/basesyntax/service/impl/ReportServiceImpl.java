package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity" + System.lineSeparator();
    private static final String CSV_SEPARATOR = ",";
    private final StorageDao storageDao;

    public ReportServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder(HEADER);
        storageDao.getAll().forEach(entry -> {
            builder.append(entry.getKey().getName())
                    .append(CSV_SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        });
        return builder.toString();
    }
}
