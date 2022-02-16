package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportCreator;

public class ReportCreatorImpl implements ReportCreator {
    private static final String COMMA_SEPARATOR = ",";
    private static final String FIRST_LINE = "fruit,quantity";
    private final StorageDao storageDao;

    public ReportCreatorImpl() {
        this.storageDao = new StorageDaoImpl();
    }

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder(FIRST_LINE);
        for (Fruit fruit : storageDao.getFruitsSet()) {
            builder.append(System.lineSeparator())
                    .append(fruit)
                    .append(COMMA_SEPARATOR)
                    .append(storageDao.getQuantity(fruit));
        }
        return builder.toString().trim();
    }
}
