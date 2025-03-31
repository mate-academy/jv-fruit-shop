package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.Map;

public class ReportContentGenerator {

    public String generateReportContent() {
        StringBuilder reportContent = new StringBuilder();
        reportContent.append("fruit,quantity\n");

        for (Map.Entry<String, Integer> entry : Storage.inventory.entrySet()) {
            reportContent.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append("\n");
        }

        return reportContent.toString();
    }
}
