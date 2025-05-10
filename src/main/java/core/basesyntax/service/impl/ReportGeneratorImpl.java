package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String FIRST_LINE = "fruit,quantity";
    private static final String COMMA = ",";
    private FruitStorageDao fruitStorageDao;

    public ReportGeneratorImpl(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public String generateReport() {
        Map<String, Integer> fruitData = fruitStorageDao.getFruits();
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(FIRST_LINE).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : fruitData.entrySet()) {
            String line = entry.getKey() + COMMA + entry.getValue();
            reportBuilder.append(line).append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
