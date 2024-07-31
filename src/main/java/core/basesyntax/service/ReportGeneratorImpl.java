package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit,quantity\n";

    @Override
    public String getReport() {
        StringBuilder reportBuilder = new StringBuilder(REPORT_HEADER);
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            reportBuilder.append(entry.getKey()).append(",").append(entry.getValue()).append("\n");
        }
        return reportBuilder.toString();
    }
}
