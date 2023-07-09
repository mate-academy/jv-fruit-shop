package core.basesyntax.service.impl;

import core.basesyntax.database.Storage;
import core.basesyntax.service.GeneratingReportService;
import java.util.Map;

public class GeneratingReportServiceImpl implements GeneratingReportService {
    private static final String LINE_SEPARATOR = ",";

    @Override
    public String generateReport() {
        StringBuilder reportData = new StringBuilder();
        reportData.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> entryLine : Storage.fruitsStorage.entrySet()) {
            reportData.append(entryLine.getKey())
                    .append(LINE_SEPARATOR)
                    .append(entryLine.getValue().toString())
                    .append(System.lineSeparator());
        }
        return reportData.toString();
    }
}
