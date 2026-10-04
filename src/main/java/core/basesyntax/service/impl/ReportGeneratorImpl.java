package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String CSV_SEPARATOR = ",";

    @Override
    public String getReport() {
        Map<String, Integer> storage = Storage.getStorage();
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(REPORT_HEADER).append(LINE_SEPARATOR);
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            reportBuilder.append(entry.getKey())
                    .append(CSV_SEPARATOR)
                    .append(entry.getValue())
                    .append(LINE_SEPARATOR);
        }
        return reportBuilder.toString();
    }
}
