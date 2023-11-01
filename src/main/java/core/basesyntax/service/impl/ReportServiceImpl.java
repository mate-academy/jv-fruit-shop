package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public String generateReport(Map<String, Integer> map) {
        StringBuilder builder = new StringBuilder();
        builder.append("fruit,").append("quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            builder.append(key).append(",").append(value).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
