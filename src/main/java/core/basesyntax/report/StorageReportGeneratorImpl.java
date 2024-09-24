package core.basesyntax.report;

import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageReportGeneratorImpl implements StorageReportGenerator {
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.getAllFruits().entrySet()) {
            report.append(entry.getKey()).append(",").append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();

    }
}
