package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    public static final String DATA_SEPARATOR = ",";

    @Override
    public String getReport(Map<String, Integer> fruitMap) {
        StringBuilder reportBuilder = new StringBuilder("fruit,quantity" + System.lineSeparator());
        for (Map.Entry<String, Integer> set : fruitMap.entrySet()) {
            reportBuilder.append(set.getKey()).append(DATA_SEPARATOR).append(set.getValue()).append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
