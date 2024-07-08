package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.storage.Storage;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String FIRST_LINE = "fruit,quantity";
    private static final Storage STORAGE = new Storage();

    @Override
    public String getReport() {
        StringBuilder resultingReport = new StringBuilder();
        resultingReport.append(FIRST_LINE);
        for (Fruit fruit : STORAGE.getFruits()) {
            resultingReport.append(System.lineSeparator())
                    .append(fruit.getFruitName()).append(",")
                    .append(fruit.getQuantity());
        }
        return resultingReport.toString();
    }
}
