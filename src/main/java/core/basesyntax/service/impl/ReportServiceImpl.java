package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_TITLE = "fruit,quantity" + System.lineSeparator();
    private static final String SEPARATOR = ",";
    private final Map<String, Integer> totalFruitMap;

    public ReportServiceImpl() {
        Storage storage = new Storage();
        totalFruitMap = storage.getFruitsStorage();
    }

    @Override
    public String generateReport() {
        return REPORT_TITLE + totalFruitMap.entrySet().stream()
                .map(entry -> entry.getKey() + SEPARATOR + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
