package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.Map;

public class ReportContentGenerator {

    private static final String HEADER = "fruit,quantity\n";
    private static final String SEPARATOR = ",";
    private static final String NEW_LINE = "\n";

    public String generateReportContent() {
        StringBuilder reportContent = new StringBuilder();

        reportContent.append(HEADER);

        for (Map.Entry<String, Integer> entry : Storage.inventory.entrySet()) {
            reportContent.append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue())
                    .append(NEW_LINE);
        }

        return reportContent.toString();
    }
}

