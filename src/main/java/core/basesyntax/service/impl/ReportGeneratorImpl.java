package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String FIRST_LINE = "fruit,quantity";
    private static final Storage STORAGE = new Storage();

    @Override
    public String getReport() {
        StringBuilder resultingReport = new StringBuilder();
        resultingReport.append(FIRST_LINE);
        for (Map.Entry<String, Fruit> entry : STORAGE.getFruits().entrySet()) {
            resultingReport.append(System.lineSeparator())
                    .append(entry.getValue().getFruitName()).append(",")
                    .append(entry.getValue().getQuantity());
        }
        return resultingReport.toString();
    }
}
