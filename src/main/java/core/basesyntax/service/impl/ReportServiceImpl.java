package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String COMMA = ",";
    private static final String FIRST_LINE = "fruit,quantity";

    @Override
    public String getReport(Map<String, Integer> map) {
        StringBuilder tmp = new StringBuilder(FIRST_LINE);
        map.forEach((key, value) -> tmp.append(System.lineSeparator())
                .append(key)
                .append(COMMA)
                .append(value));
        return tmp.toString();
    }
}
