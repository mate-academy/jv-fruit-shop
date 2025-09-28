package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append(HEADER).append(System.lineSeparator());

        Storage.inventory.forEach((fruit, quantity) ->
                report.append(fruit)
                        .append(COMMA)
                        .append(quantity)
                        .append(System.lineSeparator())
        );

        return report.toString();
    }
}
