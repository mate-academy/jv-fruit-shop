package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportGeneratorImpl implements ReportService {
    private static final String SEPARATE = ", ";

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("fruit, quantity")
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.fruitsStorage.entrySet()) {
            report.append(entry.getKey() + SEPARATE + entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
