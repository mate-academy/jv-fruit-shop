package core.basesyntax.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportService {
    private static final String HEAD_REPORT = "fruit,quantity";
    private static final String REGEX_COMMA = ",";

    public List<String> generateReport(Map<String, Integer> data) {
        List<String> report = new ArrayList<>();
        report.add(HEAD_REPORT);
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            report.add(key + REGEX_COMMA + value);
        }
        return report;
    }
}
