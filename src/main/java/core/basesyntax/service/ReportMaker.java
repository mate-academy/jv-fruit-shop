package core.basesyntax.service;

import java.util.Map;

public class ReportMaker {
    private static final String REPORT_HEAD = "fruit,quantity";
    private static final String SEPARATOR = ",";

    public String make(Map<String, Integer> data) {
        StringBuilder report = new StringBuilder(REPORT_HEAD).append(System.lineSeparator());
        for (Map.Entry<String, Integer> fruitInfo : data.entrySet()) {
            report.append(fruitInfo.getKey())
                    .append(SEPARATOR)
                    .append(fruitInfo.getValue())
                    .append(System.lineSeparator())
                    .toString();
        }
        return report.toString().trim();
    }
}
