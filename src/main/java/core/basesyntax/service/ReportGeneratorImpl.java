package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder(REPORT_HEADER);
        for (Fruit fruit : Storage.getFruits()) {
            report.append(System.lineSeparator())
                    .append(fruit.getName())
                    .append(SEPARATOR)
                    .append(fruit.getQuantity());
        }
        return report.toString();
    }
}
