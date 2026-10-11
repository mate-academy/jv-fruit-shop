package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String SYSTEM_SEPARATOR = System.lineSeparator();

    @Override
    public String getReport() {
        StringBuilder reportBuilder = new StringBuilder(REPORT_HEADER).append(SYSTEM_SEPARATOR);
        for (Map.Entry<String, Integer> entry : Storage.getStorage().entrySet()) {
            reportBuilder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(SYSTEM_SEPARATOR);
        }
        return reportBuilder.toString().trim();
    }
}
