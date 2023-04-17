package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_TITLE = "fruit,quantity\n";
    private static final String SEPARATOR = ",";
    private static final Map<String, Integer> TOTAL_FRUIT_MAP = Storage.fruitsStorage;

    @Override
    public String generateReport() {
        return REPORT_TITLE + TOTAL_FRUIT_MAP.entrySet().stream()
                .map(key -> key.getKey() + SEPARATOR + key.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
