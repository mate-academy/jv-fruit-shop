package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final Map<String, Integer> STORAGE = Storage.fruits;
    private static final String END_LINE = System.lineSeparator();
    private static final String COLUMNS = "fruit,quantity" + END_LINE;
    private static final String WORDS_SPLITERATOR = ",";

    @Override
    public String getReport() {
        String report = COLUMNS;
        report += STORAGE.keySet().stream()
                .map(key -> key + WORDS_SPLITERATOR + STORAGE.get(key) + END_LINE)
                .collect(Collectors.joining());
        return report;
    }
}
