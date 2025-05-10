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
    public String getReport() {
        StringBuilder report = new StringBuilder("fruit,quantity\n");
        for (Map.Entry<String, Integer> entry : storage.getAllFruits().entrySet()) {
            report.append(entry.getKey()).append(",").append(entry.getValue()).append("\n");
        }
        return report.toString();
    }
}
