package core.basesyntax.service.storageservice;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.product.Fruit;
import java.util.Map;

public class StorageReportServiceImpl implements StorageReportService {
    private static final String TITLE = "fruit,quantity\n";
    private static final String SPLITTER = ",";
    private final StorageDao storageDao;

    public StorageReportServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String getReport() {
        StringBuilder stringReport = new StringBuilder(TITLE);
        for (Map.Entry<Fruit, Integer> entry : storageDao.getAll().entrySet()) {
            stringReport.append(entry.getKey().getName())
                    .append(SPLITTER)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringReport.toString();
    }
}
