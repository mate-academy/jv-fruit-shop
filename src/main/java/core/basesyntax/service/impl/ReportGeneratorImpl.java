package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private final FruitStorage storage;

    public ReportGeneratorImpl(FruitStorage storage) {
        this.storage = storage;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity");
        report.append(System.lineSeparator());

        for (Map.Entry<String, Integer> entry : storage.getAll().entrySet()) {
            report.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
