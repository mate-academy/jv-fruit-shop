package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.DailyReportMaker;

public class DailyReportMakerImpl implements DailyReportMaker {
    private static final String REPORT_HEADER = "fruit,quantity";
    private final StorageDao storageDao;
    
    public DailyReportMakerImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String makeReport() {
        StringBuilder builder = new StringBuilder(REPORT_HEADER);
        for (Fruit fruit : storageDao.getAllFruits()) {
            builder.append(System.lineSeparator());
            builder.append(fruit.getFruitType());
            builder.append(",");
            builder.append(fruit.getFruitQuantity());
        }
        return builder.toString();
    }
}
