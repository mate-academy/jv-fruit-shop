package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.GenerateReportService;
import java.util.Map;

public class GenerateReportServiceImpl implements GenerateReportService {
    private static final String COMMA = ",";
    private static final String REPORT_TITLE = "fruit,quantity\n";

    @Override
    public String generateReport() {
        Map<String, Integer> fromStorageDb = Storage.fruits;
        StringBuilder reportBuilder = new StringBuilder(REPORT_TITLE);
        for (Map.Entry<String, Integer> entry : fromStorageDb.entrySet()) {
            reportBuilder.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }

}
