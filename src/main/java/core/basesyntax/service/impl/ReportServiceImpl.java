package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String COLUMN_SEPARATOR = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String REPORT_HEADER = "fruit,quantity";
    private final Map<String, Integer> storage;

    public ReportServiceImpl(Map<String, Integer> storage) {
        this.storage = storage;
    }

    @Override
    public String getReport() {
        return REPORT_HEADER + storage.entrySet().stream()
                .map(fruit -> LINE_SEPARATOR + fruit.getKey()
                        + COLUMN_SEPARATOR + fruit.getValue())
                .collect(Collectors.joining());
    }
}
