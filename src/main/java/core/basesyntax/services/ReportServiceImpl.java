package core.basesyntax.services;

import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE_STRING_OF_FILE = "fruit,quantity";

    public String createReport(Map<String, Integer> dayResult) {
        StringBuilder builder = new StringBuilder(TITLE_STRING_OF_FILE + System.lineSeparator());
        for (Map.Entry<String, Integer> entry : dayResult.entrySet()) {
            builder.append(entry.getKey()).append(" ")
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
