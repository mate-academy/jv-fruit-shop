package core.basesyntax.impl;

import core.basesyntax.ReportGenerator;
import core.basesyntax.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String generateReport(Storage storage) {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity\n");
        for (Map.Entry<String, Integer> entry : storage.getStorage().entrySet()) {
            report.append(entry.getKey()).append(",").append(entry.getValue()).append("\n");
        }
        return report.toString();
    }
}
