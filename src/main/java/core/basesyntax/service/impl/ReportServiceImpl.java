package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    public static final String TITLE_FOR_REPORT = "fruit,quantity";
    public static final String COMMA_SEPARATOR = ",";

    @Override
    public String makeReport() {
        StringBuilder report = new StringBuilder();
        report.append(TITLE_FOR_REPORT).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            report.append(entry.getKey()).append(COMMA_SEPARATOR)
                            .append(entry.getValue()).append(System.lineSeparator());
        }
        return report.toString().trim();
    }
}
