package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_TITLE = "fruit,quantity";
    private static final String COMMA = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private StorageDao storageDao;

    public ReportServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder(REPORT_TITLE);
        for (Map.Entry<Fruit, Integer> entry : storageDao.getAll()) {
            stringBuilder
                    .append(LINE_SEPARATOR)
                    .append(entry.getKey().getName())
                    .append(COMMA)
                    .append(entry.getValue());
        }

        return stringBuilder.toString();
    }
}
