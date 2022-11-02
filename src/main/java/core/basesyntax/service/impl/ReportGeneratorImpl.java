package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String CONTENT_SEPARATOR = ",";
    private static final String REPORT_FIRST_LINE = "fruit" + CONTENT_SEPARATOR + "quantity";

    public String report(FruitDao storageDao) {
        StringBuilder report = new StringBuilder();
        report.append(REPORT_FIRST_LINE)
                .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : storageDao.getEntrySet()) {
            report.append(entry.getKey().getType())
                    .append(CONTENT_SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString().trim();
    }
}
