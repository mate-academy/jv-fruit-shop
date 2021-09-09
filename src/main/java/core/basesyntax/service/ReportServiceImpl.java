package core.basesyntax.service;

import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String COLUMN_NAMES = "fruit,quantity";

    @Override
    public String createReport(Map<String, Integer> fruitsStorage) {
        StringBuilder stringBuilder = new StringBuilder(COLUMN_NAMES)
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> fruits : fruitsStorage.entrySet()) {
            stringBuilder.append(fruits.getKey())
                    .append(",")
                    .append(fruits.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
