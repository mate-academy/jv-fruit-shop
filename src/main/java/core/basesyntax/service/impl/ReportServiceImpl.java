package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity" + System.lineSeparator();
    private static final String COMMA = ",";
    private final StorageDao storageDao;

    public ReportServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String makeReport() {
        StringBuilder builder = new StringBuilder(HEADER);
        for (Map.Entry<Fruit, Integer> entry : storageDao.getAll()) {
            builder.append(entry.getKey().getName())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
