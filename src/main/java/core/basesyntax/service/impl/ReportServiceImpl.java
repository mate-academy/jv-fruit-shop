package core.basesyntax.service.impl;

import core.basesyntax.database.FruitStorage;
import core.basesyntax.service.ReportService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String NAME = "fruit,quantity\n";
    private static final String SEPARATOR = ",";
    private static final Map<String, Integer> STORAGE = FruitStorage.fruit;

    @Override
    public String report() {
        String report = NAME;
        report += STORAGE.keySet().stream()
                .map(k -> k + SEPARATOR + STORAGE.get(k) + System.lineSeparator())
                .collect(Collectors.joining());
        return report;
    }
}
