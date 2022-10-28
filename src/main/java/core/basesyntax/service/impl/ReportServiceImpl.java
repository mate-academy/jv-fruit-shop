package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String WORDS_SPLITERATOR = ",";
    private static final String END_LINE = System.lineSeparator();
    private static final String COLUMNS = "fruit,quantity";

    @Override
    public String getReport(Map<String, Integer> dataForReport) {
        String report = COLUMNS + END_LINE;
        report += dataForReport.keySet().stream()
                .map(key -> key + WORDS_SPLITERATOR + dataForReport.get(key) + END_LINE)
                .collect(Collectors.joining());
        return report;
    }
}
