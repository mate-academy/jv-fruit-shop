package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String SEPARATOR = ",";
    private static final Map<String, Integer> STORE = Storage.FRUITS;
    private static final String REPORT_LEGEND = "fruit,quantity\n";

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder(REPORT_LEGEND);
        for (var entry : STORE.entrySet()) {
            report.append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
