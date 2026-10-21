package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private Storage storage;

    public ReportGeneratorImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();

        report.append("fruit,quantity").append("\n");

        Map<String, Integer> fruits = storage.getAll();
        for (Map.Entry<String, Integer> entry : fruits.entrySet()) {
            report
                    .append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append("\n");
        }
        return report.toString();
    }
}
