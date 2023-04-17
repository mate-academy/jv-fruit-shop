package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_TITLE = "fruit,quantity\n";
    private static final String SEPARATOR = ",";
    private static Map<String, Integer> TOTAL_FRUIT_MAP;

    public ReportServiceImpl() {
        Storage storage = new Storage();
        TOTAL_FRUIT_MAP = storage.getFruitsStorage();
    }

    @Override
    public String generateReport() {
        return REPORT_TITLE + TOTAL_FRUIT_MAP.entrySet().stream()
                .map(entry -> entry.getKey() + SEPARATOR + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
