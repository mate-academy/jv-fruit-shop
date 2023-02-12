package service.impl;

import db.ShopStorage;
import java.util.Map;
import java.util.stream.Collectors;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final Map<String, Integer> STORAGE = ShopStorage.fruitsStorage;
    private static final String END_LINE = System.lineSeparator();
    private static final String COLUMNS = "fruit,quantity" + END_LINE;
    private static final String LINE_SPLITERATOR = ",";

    @Override
    public String getReport() {
        String report = COLUMNS;
        report += STORAGE.keySet().stream()
                .map(key -> key + LINE_SPLITERATOR + STORAGE.get(key) + END_LINE)
                .collect(Collectors.joining());
        return report;
    }
}
