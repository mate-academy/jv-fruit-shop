package core.basesyntax.service.impl;

import core.basesyntax.database.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String CSV_SEPARATOR = ",";

    @Override
    public String generateReport() {
        StringBuilder reportData = new StringBuilder();
        reportData.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> entryLine : Storage.fruitsStorage.entrySet()) {
            reportData.append(entryLine.getKey())
                    .append(CSV_SEPARATOR)
                    .append(entryLine.getValue())
                    .append(System.lineSeparator());
        }
        return reportData.toString();
    }
}
