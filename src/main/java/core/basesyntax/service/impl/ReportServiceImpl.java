package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public String getReport(StringBuilder reportBuilder, Map<String, Integer> fruitMap) {
        for (Map.Entry<String, Integer> set : fruitMap.entrySet()) {
            reportBuilder.append(set.getKey()).append(",").append(set.getValue()).append("\n");
        }
        return reportBuilder.toString();
    }
}
