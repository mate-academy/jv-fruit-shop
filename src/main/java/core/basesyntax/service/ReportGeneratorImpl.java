package core.basesyntax.service;

import core.basesyntax.storage.Storage;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder("fruit,quantity\n");
        Storage.fruits.forEach((fruit, quantity) -> report.append(fruit)
                .append(",").append(quantity).append("\n"));
        return report.toString();
    }
}
