package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport(Storage report) {
        StringBuilder newReport = new StringBuilder();
        newReport.append("fruit,quantity").append("\n");
        for (Map.Entry<String, Integer> entry : report.getAll().entrySet()) {
            newReport.append(entry.getKey()).append(",")
                    .append(entry.getValue()).append("\n");
        }
        return newReport.toString();
    }
}
