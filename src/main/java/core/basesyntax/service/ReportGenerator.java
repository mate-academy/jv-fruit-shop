package core.basesyntax.service;

import java.util.HashMap;
import java.util.Map;

public class ReportGenerator {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String COMMA = ",";
    private static final String SEPARATOR = System.lineSeparator();

    public String create(HashMap<String, Integer> data) {
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
