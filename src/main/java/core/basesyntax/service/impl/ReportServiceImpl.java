package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public String getReport(Map<String, Integer> fruitsMap) {
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity");
        fruitsMap.forEach((key, value) ->
                stringBuilder.append(System.lineSeparator())
                        .append(key)
                        .append(",")
                        .append(value));
        return stringBuilder.toString();
    }
}
