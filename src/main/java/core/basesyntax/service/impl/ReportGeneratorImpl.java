package core.basesyntax.service.impl;

import core.basesyntax.db.FruitDao;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String FIRST_COLUMN = "fruit";
    private static final String SECOND_COLUMN = "quantity";
    private static final String DELIMITER = ",";
    private static final String NEW_LINE = "\n";
    private final FruitDao fruitDao;

    public ReportGeneratorImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append(FIRST_COLUMN + DELIMITER + SECOND_COLUMN + NEW_LINE);

        Map<String, Integer> fruitDB = fruitDao.getFruitDB();
        for (Map.Entry<String, Integer> entry : fruitDB.entrySet()) {
            report.append(entry.getKey())
                    .append(DELIMITER)
                    .append(entry.getValue())
                    .append(NEW_LINE);
        }
        return report.toString();
    }
}
