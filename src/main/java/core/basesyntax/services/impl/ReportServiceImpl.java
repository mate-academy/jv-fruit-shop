package core.basesyntax.services.impl;

import core.basesyntax.database.Storage;
import core.basesyntax.services.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String HEADING = "fruit,quantity \n";
    private static final String SEPARATOR = ",";

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder(HEADING);
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            report.append(entry.getKey() + SEPARATOR);
            report.append(entry.getValue() + System.lineSeparator());
        }
        return report.toString();
    }
}
