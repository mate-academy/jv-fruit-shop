package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE = "fruits,quantity";
    private static final String INDENTATION = "\t";
    private static final String SEPARATOR = ",";

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder()
                .append(INDENTATION)
                .append(TITLE);
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            report.append(System.lineSeparator())
                    .append(INDENTATION)
                    .append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue());
        }
        return report.toString();
    }
}
