package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGeneratorService;
import java.util.stream.Collectors;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String KEY_AND_VALUE_SEPARATOR = ",";

    private StringBuilder report;

    public ReportGeneratorServiceImpl() {
        report = new StringBuilder();
    }

    @Override
    public String generateReport() {
        String reportBody = Storage.getFruitStorage()
                                .entrySet()
                                .stream()
                                .map(entry ->
                                        System.lineSeparator()
                                        + entry.getKey()
                                        + KEY_AND_VALUE_SEPARATOR
                                        + entry.getValue().toString())
                                .collect(Collectors.joining());

        return report.append(REPORT_HEADER)
                    .append(reportBody)
                    .toString();
    }
}
