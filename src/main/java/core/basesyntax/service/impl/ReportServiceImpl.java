package core.basesyntax.service.impl;


import java.util.Map;
import java.util.stream.Collectors;
import core.basesyntax.service.ReportService;
import core.basesyntax.db.Storage;

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
