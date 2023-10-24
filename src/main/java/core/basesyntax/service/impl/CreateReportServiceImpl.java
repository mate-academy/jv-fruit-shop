package core.basesyntax.service.impl;

import core.basesyntax.db.dao.StorageDao;
import core.basesyntax.db.dao.StorageDaoImpl;
import core.basesyntax.service.CreateReportService;
import java.util.Map;

public class CreateReportServiceImpl implements CreateReportService {
    private static final String FRUIT_COLUMN = "fruit";
    private static final String QUANTITY_COLUMN = "quantity";
    private static final char SPLIT_CHARACTER = ',';
    private final StorageDao storageDao = new StorageDaoImpl();
    private final StringBuilder reportCreator = new StringBuilder();

    @Override
    public String createReport() {
        Map<String, Long> data = storageDao.getInfo();
        reportCreator.append(FRUIT_COLUMN)
                .append(SPLIT_CHARACTER)
                .append(QUANTITY_COLUMN);

        for (Map.Entry<String, Long> entry : data.entrySet()) {
            reportCreator.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(SPLIT_CHARACTER)
                    .append(entry.getValue());
        }

        return reportCreator.toString();
    }
}
