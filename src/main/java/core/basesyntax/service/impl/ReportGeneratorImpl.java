package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String reportGenerate() {
        String report = Storage.STORAGE.entrySet().stream()
                .map(e -> e.getKey() + COMMA + e.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
        return REPORT_HEADER + report;
    }
}
