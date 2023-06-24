package service.impl;

import db.FruitStorage;
import java.util.Map;
import java.util.stream.Collectors;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE = "fruit,quantity\n";
    private static final String SEPARATOR = ",";
    private static final Map<String, Integer> STORAGE = FruitStorage.fruits;

    @Override
    public String report() {
        String report = TITLE;
        report += STORAGE.keySet().stream()
                .map(fruit -> fruit + SEPARATOR + STORAGE.get(fruit) + System.lineSeparator())
                .collect(Collectors.joining());
        return report;
    }
}
