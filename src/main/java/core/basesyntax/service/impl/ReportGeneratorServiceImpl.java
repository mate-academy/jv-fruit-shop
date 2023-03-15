package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGeneratorService;
import java.util.Map;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    public static final String HEADER = "fruit quantity";
    public static final String SPLITTER = ",";

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder(HEADER);
        for (Map.Entry<String, Integer> entry: Storage.storage.entrySet()) {
            report.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(SPLITTER)
                    .append(entry.getValue());
        }
        return report.toString();
    }
}
