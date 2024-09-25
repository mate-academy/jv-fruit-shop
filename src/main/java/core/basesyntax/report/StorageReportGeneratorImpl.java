package core.basesyntax.report;

import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageReportGeneratorImpl implements StorageReportGenerator {
    private static final String REPORT_HEADER = "fruit,quantity";

    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append(REPORT_HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.getAllFruits().entrySet()) {
            report.append(entry.getKey()).append(",").append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
