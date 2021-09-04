package core.basesyntax.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE_REPORT = "fruit, quantity";
    private static final String COMMA = ",";

    @Override
    public List<String> createReport(Map<String, Integer> mapQuantityFruit) {
        List<String> report = new ArrayList<>();
        report.add(TITLE_REPORT);
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : mapQuantityFruit.entrySet()) {
            builder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue());
        }
        report.add(builder.toString());
        return report;
    }
}
