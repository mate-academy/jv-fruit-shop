package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import java.util.Map;

public class ReportService {
    private FruitDao fruitDao;

    public ReportService(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("type,fruit\n");
        for (Map.Entry<String, Integer> fruit : fruitDao.getFruits()) {
            report.append(fruit.getKey() + "," + fruit.getValue() + System.lineSeparator());
        }
        return report.toString();
    }
}
