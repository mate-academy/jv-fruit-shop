package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.ReportService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE = "fruit,quantity\n";
    private static final String SEPARATOR = ",";
    private static final Map<String, Integer> STORAGE = FruitStorage.fruits;

    @Override
    public String report() {
        String report = TITLE;
        report += STORAGE.keySet().stream()
                .map(k -> k + SEPARATOR + STORAGE.get(k) + System.lineSeparator())
                .collect(Collectors.joining());
        return report;
    }
}
