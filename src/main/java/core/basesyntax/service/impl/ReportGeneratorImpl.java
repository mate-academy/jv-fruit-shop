package core.basesyntax.service.impl;

import core.basesyntax.db.StorageFruit;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();

        report.append("fruit,quantity\n");

        for (Map.Entry<String, Integer> entry : StorageFruit.storage.entrySet()) {
            report.append(entry.getKey()).append(",").append(entry.getValue()).append("\n");
        }
        return report.toString();
    }
}
