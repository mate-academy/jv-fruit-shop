package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit,quantity";
    private final FruitDao fruitDao;

    public ReportGeneratorImpl(FruitDao fruitDao) {
        if (fruitDao == null) {
            throw new RuntimeException("FruitDao cannot be null");
        }
        this.fruitDao = fruitDao;
    }

    @Override
    public String getReport() {
        Map<String, Integer> allFruits = fruitDao.getAllFruits();

        if (allFruits == null) {
            throw new RuntimeException("Data from storage is null, cannot generate report");
        }

        StringBuilder report = new StringBuilder(REPORT_HEADER).append(System.lineSeparator());

        for (Map.Entry<String, Integer> entry : allFruits.entrySet()) {
            report.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
