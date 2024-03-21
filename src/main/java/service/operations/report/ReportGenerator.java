package service.operations.report;

import java.util.Map;
import model.Fruit;

public class ReportGenerator {
    private static final String SPLITTER_CSV = ",";
    private static final String SPLITTER_NEW_LINE = System.lineSeparator();

    public static String generateReportContent(Map<Fruit, Integer> storage) {
        StringBuilder content = new StringBuilder();
        content.append("fruit,quantity").append(SPLITTER_NEW_LINE);
        for (Map.Entry<Fruit, Integer> entry : storage.entrySet()) {
            content.append(entry.getKey().name()).append(SPLITTER_CSV).append(entry.getValue())
                    .append(SPLITTER_NEW_LINE);
        }
        return content.toString();
    }
}
