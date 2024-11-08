package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import core.basesyntax.storage.FruitStorage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private final FruitStorage storage;

    public ReportGeneratorImpl(FruitStorage storage) {
        this.storage = storage;
    }

    @Override
    public String generateReport() {
        StringBuilder transactionReport = new StringBuilder("fruit,quantity");

        for (Map.Entry<String, Integer> entry : storage.getAllFruits().entrySet()) {
            transactionReport.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(",")
                    .append(entry.getValue());
        }
        return transactionReport.toString();
    }
}
