package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportCreator;

public class ReportCreatorImpl implements ReportCreator {
    private StorageDao storageDao;

    public ReportCreatorImpl() {
        this.storageDao = new StorageDaoImpl();
    }

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder("fruit,quantity" + System.lineSeparator());
        for (Fruit fruit : storageDao.getFruitsSet()) {
            builder.append(fruit)
                    .append(",")
                    .append(storageDao.getQuantity(fruit))
                    .append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
