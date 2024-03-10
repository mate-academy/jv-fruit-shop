package service;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    public static final String COLUMN_NAMES = "fruit,quantity";
    public static final String SEPARATOR = ",";

    @Override
    public String generate(Map<String, Integer> storageData) {
        StringBuilder report = new StringBuilder(COLUMN_NAMES).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : storageData.entrySet()) {
            report.append(entry.getKey())
                        .append(SEPARATOR)
                        .append(entry.getValue())
                        .append(System.lineSeparator());
        }
        return report.toString();
    }
}
