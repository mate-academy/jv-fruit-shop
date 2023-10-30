package model;

import java.util.Map;

public class DailyReport {
    private static final String DATA_SEPARATOR = ",";
    private static final String REPORT_HEADER = "fruit,quantity";
    private final Map<String, Integer> fruitQuantity;

    public DailyReport(Map<String, Integer> fruitQuantity) {
        this.fruitQuantity = fruitQuantity;
    }

    public String createReportString() {
        StringBuilder builder = new StringBuilder(REPORT_HEADER);
        for (String fruit : fruitQuantity.keySet()) {
            builder.append(System.lineSeparator())
                    .append(fruit)
                    .append(DATA_SEPARATOR)
                    .append(fruitQuantity.get(fruit));
        }
        return builder.toString();
    }
}
