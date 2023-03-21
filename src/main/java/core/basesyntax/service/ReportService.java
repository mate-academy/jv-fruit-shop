package core.basesyntax.service;

import java.util.Map;

public class ReportService {

    public String getReport(Map<String, Integer> map) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            stringBuilder.append(entry.getKey()).append(",")
                     .append(entry.getValue()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
