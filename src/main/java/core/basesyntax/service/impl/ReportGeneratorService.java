package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.HashMap;
import java.util.Map;

public class ReportGeneratorService implements ReportService {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String COMMA = ",";
    private static final String SEPARATOR = System.lineSeparator();

    @Override
    public String createReport(HashMap<String, Integer> data) {
        StringBuilder report = new StringBuilder();
        report.append(REPORT_HEADER).append(SEPARATOR);
        for (Map.Entry<String, Integer> set :
                data.entrySet()) {
            String key = set.getKey();
            Integer value = set.getValue();
            report.append(key).append(COMMA).append(value).append(SEPARATOR);
        }
        return report.toString();
    }
}
