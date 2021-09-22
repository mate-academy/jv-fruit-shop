package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String COMMA = ",";
    private static final String FIRST_LINE = "fruit,quantity";

    @Override
    public String getReport(Map<String, Integer> map) {
        StringBuilder tmp = new StringBuilder(FIRST_LINE);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            tmp.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue());
        }
        return tmp.toString();
    }
}
