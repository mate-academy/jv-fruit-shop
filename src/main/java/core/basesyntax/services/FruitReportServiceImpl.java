package core.basesyntax.services;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import java.util.Map;

public class FruitReportServiceImpl implements FruitReportService {
    private FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();

    @Override
    public String createReport(Map<String, Integer> fruits) {
        StringBuilder report = new StringBuilder("fruit,quantity");
        for (Map.Entry<String, Integer> entry : fruits.entrySet()) {
            report.append(System.lineSeparator()).append(entry.getKey())
                    .append(",").append(entry.getValue());
        }
        return report.toString();
    }
}
