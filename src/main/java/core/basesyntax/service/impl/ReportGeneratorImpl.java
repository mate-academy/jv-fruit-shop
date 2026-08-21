package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder("fruit,quantity");
        for (Map.Entry<String, Integer> entry : Storage.getFruits().entrySet()) {
            report.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(",")
                    .append(entry.getValue());
        }
        return report.toString();
    }
}
