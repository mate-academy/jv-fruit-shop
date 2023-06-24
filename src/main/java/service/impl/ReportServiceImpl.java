package service.impl;

import java.util.Map;
import model.Fruit;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE = "fruit,quantity";
    private static final String REGEX = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public String createReport(Map<Fruit, Integer> fruitStorage) {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(TITLE).append(LINE_SEPARATOR);
        fruitStorage.forEach((key, value) -> reportBuilder.append(key.getName())
                .append(REGEX)
                .append(value)
                .append(LINE_SEPARATOR));
        return reportBuilder.toString();
    }
}
