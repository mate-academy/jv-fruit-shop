package core.basesyntax.service.impl;

import core.basesyntax.service.db.Storage;
import core.basesyntax.service.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE_OF_REPORT = "fruit,quantity";
    private static final String COMA = ",";

    @Override
    public String createReport() {
        StringBuilder result = new StringBuilder();
        result.append(TITLE_OF_REPORT);
        for (Map.Entry<String, Integer> entry: Storage.storage.entrySet()) {
            result.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(COMA)
                    .append(entry.getValue());
        }
        return result.toString();
    }
}
