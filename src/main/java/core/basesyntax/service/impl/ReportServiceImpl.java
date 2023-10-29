package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String generateReport() {
        StringBuilder reportLine = new StringBuilder(REPORT_HEADER)
                .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> row : Storage.storage.entrySet()) {
            reportLine.append(row.getKey().getName())
                    .append(SEPARATOR)
                    .append(row.getValue())
                    .append(System.lineSeparator());
        }
        return reportLine.toString();
    }
}
