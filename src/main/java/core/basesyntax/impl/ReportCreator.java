package core.basesyntax.impl;

import core.basesyntax.database.Storage;
import core.basesyntax.service.CreateReport;
import java.util.Map;

public class ReportCreator implements CreateReport {
    private static final String FIRST_LINE = "fruit,quantity";
    private static final String COMMA = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder().append(FIRST_LINE)
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            report.append(entry.getKey()).append(COMMA)
                    .append(entry.getValue()).append(LINE_SEPARATOR);
        }
        return report.toString();
    }
}
