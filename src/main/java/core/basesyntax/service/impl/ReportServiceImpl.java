package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String DEFAULT_TITLE = "fruit,quantity" + System.lineSeparator();
    private static final String COMA = ",";

    @Override
    public String getReport() {
        StringBuilder reportBuilder = new StringBuilder(DEFAULT_TITLE);
        for (Map.Entry<String, Integer> entry: Storage.storage.entrySet()) {
            reportBuilder.append(entry.getKey())
                    .append(COMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
