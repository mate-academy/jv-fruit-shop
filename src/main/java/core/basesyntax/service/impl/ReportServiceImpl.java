package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit, quantity";

    @Override
    public String generateReport(Map<String, Integer> fruitMap) {
        StringBuilder builder = new StringBuilder(HEADER);
        for (Map.Entry<String, Integer> data : fruitMap.entrySet()) {
            builder.append(System.lineSeparator())
                    .append(data.getKey())
                    .append(",")
                    .append(data.getValue());
        }
        return builder.toString();
    }
}
