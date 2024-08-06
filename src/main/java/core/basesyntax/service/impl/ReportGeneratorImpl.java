package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder("fruit,quantity\n");
        Storage.getFruits().forEach((fruit, quantity) -> report.append(fruit)
                .append(",").append(quantity).append("\n"));
        return report.toString();
    }
}
