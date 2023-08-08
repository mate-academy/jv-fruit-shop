package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportCreatorService;
import java.util.Set;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String CSV_FIRST_LINE = "fruit,quantity" + System.lineSeparator();
    private final StorageDao storageDao;

    public ReportCreatorServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String createReport() {
        Set<Fruit> data = storageDao.getAll();
        StringBuilder stringBuilder = new StringBuilder(CSV_FIRST_LINE);
        for (Fruit fruit : data) {
            stringBuilder
                    .append(fruit.getName())
                    .append(",")
                    .append(storageDao.getAmount(fruit))
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
