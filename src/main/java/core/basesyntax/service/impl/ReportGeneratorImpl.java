package core.basesyntax.service.impl;

import core.basesyntax.data.Storage;
import core.basesyntax.service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "Fruit   Quantity ";
    private static final String REPORT_SEPARATOR = " - ";

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder(REPORT_HEADER)
                .append(System.lineSeparator());;
        Storage.getInventory().forEach((fruit, quantity) ->
                report.append(fruit).append(REPORT_SEPARATOR)
                        .append(quantity).append(System.lineSeparator()));
        return report.toString();
    }
}
