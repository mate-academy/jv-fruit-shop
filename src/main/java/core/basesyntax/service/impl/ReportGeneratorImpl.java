package core.basesyntax.service.impl;

import core.basesyntax.db.FruitsDb;
import core.basesyntax.service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    static final String START_OF_REPORT = "fruit,quantity" + System.lineSeparator();
    static final String SEPARATOR = ",";

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder(START_OF_REPORT);
        for (String fruitName : FruitsDb.fruitDb.keySet()) {
            report.append(fruitName)
                    .append(SEPARATOR)
                    .append(FruitsDb.fruitDb.get(fruitName))
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
