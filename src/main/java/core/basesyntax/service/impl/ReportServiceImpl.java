package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String DATA_SEPARATOR = ",";
    private static final String HEADER = "fruit,quantity";

    @Override
    public String getReport(Map<String, Integer> fruitMap) {
        StringBuilder reportBuilder = new StringBuilder(HEADER + System.lineSeparator());
        for (Map.Entry<String, Integer> entry : fruitMap.entrySet()) {
            reportBuilder.append(entry.getKey())
                    .append(DATA_SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
