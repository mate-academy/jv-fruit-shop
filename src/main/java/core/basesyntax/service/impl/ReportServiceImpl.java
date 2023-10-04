package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.ReportService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE = "fruit,quantity\n";
    private static final String SEPARATOR = ",";
    private static final Map<String, Integer> STORAGE = FruitStorage.getFruits();

    @Override
    public String generateReport() {
        String report = TITLE;
        report += STORAGE.keySet().stream()
                .map(fruit -> fruit + SEPARATOR + STORAGE.get(fruit) + System.lineSeparator())
                .collect(Collectors.joining());
        return report;
    }
}
