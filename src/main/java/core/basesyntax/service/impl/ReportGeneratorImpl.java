package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport(Storage storage) {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity").append(System.lineSeparator()); // Inline the header

        storage.getInventory().forEach((fruit, quantity) ->
                report.append(fruit)
                        .append(",")
                        .append(quantity)
                        .append(System.lineSeparator())
        );

        return report.toString();
    }
}
