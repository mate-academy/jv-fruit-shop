package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.ReportGenerator;
import java.util.HashMap;

public class FruitReport implements ReportGenerator {
    @Override
    public String get() {
        StorageDao storageDao = new StorageDaoImpl();
        StringBuilder report = new StringBuilder()
                .append("fruit,quantity").append(System.lineSeparator());
        HashMap<String, Integer> fruits = storageDao.getAll();
        for (String key : fruits.keySet()) {
            report.append(key).append(",")
                    .append(fruits.get(key))
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
