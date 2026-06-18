package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String COMMA_SEPARATOR = ",";

    @Override
    public String getReport() {
        String reportData = Storage.getAllEntries().entrySet().stream()
                .map(entry -> entry.getKey()
                        + COMMA_SEPARATOR + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
        if (reportData.isEmpty()) {
            return REPORT_HEADER;
        }
        return REPORT_HEADER + System.lineSeparator() + reportData;
    }
}
