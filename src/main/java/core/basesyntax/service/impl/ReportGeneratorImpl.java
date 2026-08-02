package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String CSV_SEPARATOR = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public String getReport() {
        StringBuilder reportBuilder = new StringBuilder(REPORT_HEADER);
        for (Map.Entry<String, Integer> entry : Storage.getAll().entrySet()) {
            reportBuilder.append(LINE_SEPARATOR)
                    .append(entry.getKey())
                    .append(CSV_SEPARATOR)
                    .append(entry.getValue());
        }
        return reportBuilder.toString();
    }
}
