package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String INFO_LINE = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String createReport(Map<String, Integer> storage) {
        StringBuilder tmp = new StringBuilder(INFO_LINE).append(System.lineSeparator());
        storage.forEach((key, value) -> tmp.append(key)
                .append(COMMA)
                .append(value)
                .append(System.lineSeparator()));
        return tmp.toString();
    }
}
