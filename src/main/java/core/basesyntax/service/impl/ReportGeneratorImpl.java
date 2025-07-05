package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "Report:";
    private static final String REPORT_HEADER2 = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public void reportGenerate() {
        String report = Storage.STORAGE.entrySet().stream()
                .map(e -> e.getKey() + COMMA + e.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
        System.out.println(REPORT_HEADER + "\n" + REPORT_HEADER2 + "\n" + report);
    }
}
