package core.basesyntax.db.service.impl;

import core.basesyntax.db.service.ReportCreatorService;
import java.util.Map;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String HEAD = "fruit,amount";
    private static final String REGEX = ",";

    @Override
    public String getReport(Map<String, Integer> map) {
        StringBuilder report = new StringBuilder(HEAD).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            report.append(entry.getKey())
                    .append(REGEX)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
