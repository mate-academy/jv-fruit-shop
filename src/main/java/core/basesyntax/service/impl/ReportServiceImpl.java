package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.HashMap;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE = "fruit,quantity" + System.lineSeparator();
    private static final String COMMA_SEPARATOR = ",";
    private Map<String, Integer> result = new HashMap<>();

    @Override
    public String createReportText() {
        StringBuilder report = new StringBuilder();
        report.append(TITLE);
        Storage.fruits.forEach((key, value) -> report
                .append(key)
                .append(COMMA_SEPARATOR)
                .append(value)
                .append(System.lineSeparator()));
        return report.toString();
    }
}
