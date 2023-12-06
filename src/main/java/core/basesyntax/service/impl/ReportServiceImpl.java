package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String COLUMNS = "fruit,quantity";
    private static final String COMA = ",";
    private final StringBuilder stringBuilder = new StringBuilder(COLUMNS);

    @Override
    public String createReport(Storage storage) {
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            stringBuilder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(COMA)
                    .append(entry.getValue());
        }
        return stringBuilder.toString();
    }
}
