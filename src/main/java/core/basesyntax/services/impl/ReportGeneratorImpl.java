package core.basesyntax.services.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.services.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_TITLE = "fruit,quantity";
    private static final String COMMA_SEPARATOR = ",";

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append(REPORT_TITLE).append(System.lineSeparator());

        Storage.fruits.forEach((fruit, quantity) -> report.append(fruit)
                .append(COMMA_SEPARATOR)
                .append(quantity)
                .append(System.lineSeparator()));

        return report.toString();
    }
}
