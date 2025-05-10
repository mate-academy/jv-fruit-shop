package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit,quantity" + System.lineSeparator();

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder(REPORT_HEADER);
        Storage.getFruits().forEach((fruit, quantity) ->
                report.append(fruit)
                        .append(",")
                        .append(quantity)
                        .append(System.lineSeparator())
        );
        return report.toString();
    }
}
