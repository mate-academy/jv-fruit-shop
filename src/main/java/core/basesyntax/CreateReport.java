package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class CreateReport {
    private static final String REPORT_START = "fruit,quantity";
    private static final String COMMA = ",";

    public String create(HashMap<String, Integer> data) {
        StringBuilder report = new StringBuilder();
        String separator = System.lineSeparator();
        report.append(REPORT_START).append(separator);
        for (Map.Entry<String, Integer> set :
                data.entrySet()) {
            String key = set.getKey();
            Integer value = set.getValue();
            report.append(key).append(COMMA).append(value).append(separator);
        }
        return report.toString();
    }
}

