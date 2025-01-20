package core.basesyntax.service.impl;

import core.basesyntax.data.Storage;
import core.basesyntax.service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder("Fruit   Quantity ")
                .append(System.lineSeparator());;
        Storage.getInventory().forEach((fruit, quantity) ->
                report.append(fruit).append(" - ").append(quantity).append(System.lineSeparator()));
        return report.toString();
    }
}
