package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.Map;

public class ReportService {
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String HEADER = "fruit,quantity" + NEW_LINE_SEPARATOR;
    private static final String CSV_SEPARATOR = ",";

    public String generateReport() {
        StringBuilder report = new StringBuilder(HEADER);
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            report
                    .append(entry.getKey())
                    .append(CSV_SEPARATOR)
                    .append(entry.getValue())
                    .append(NEW_LINE_SEPARATOR);
        }
        return report.toString();
    }
}
