package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String CONTENT_SEPARATOR = ",";
    private static final String REPORT_FIRST_LINE = "fruit" + CONTENT_SEPARATOR + "quantity";

    public String generateReport(FruitDao storageDao) {
        StringBuilder report = new StringBuilder();
        report.append(REPORT_FIRST_LINE);
        for (Map.Entry<Fruit, Integer> entry : storageDao.getEntrySet()) {
            report.append(System.lineSeparator())
                    .append(entry.getKey().getType())
                    .append(CONTENT_SEPARATOR)
                    .append(entry.getValue());
        }
        return report.toString();
    }
}
