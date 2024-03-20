package service.operations.report;

import java.util.Map;
import model.Fruit;

public class ReportGenerator {
    public static String generateReportContent(Map<Fruit, Integer> storage) {
        StringBuilder content = new StringBuilder();
        content.append("fruit,quantity\n");
        for (Map.Entry<Fruit, Integer> entry : storage.entrySet()) {
            content.append(entry.getKey().name()).append(",").append(entry.getValue()).append("\n");
        }
        return content.toString();
    }
}

