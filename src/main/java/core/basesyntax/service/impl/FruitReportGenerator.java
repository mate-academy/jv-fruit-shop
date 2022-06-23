package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class FruitReportGenerator implements ReportGenerator {
    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public String create() {
        StringBuilder reportBuilder = new StringBuilder()
                .append("fruit,quantity").append(System.lineSeparator());
        Map<String, Integer> fruits = storageDao.getAll();
        for (String fruit : fruits.keySet()) {
            reportBuilder.append(fruit).append(",")
                    .append(fruits.get(fruit))
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
