package core.basesyntax.service.impl;

import core.basesyntax.service.ReportCreatorService;
import java.util.Map;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String HEADER = "fruit,quantity";
    private static final String DELIMITER = ",";

    public String createReport(Map<String, Integer> mapFruit) {
        StringBuilder report = new StringBuilder(HEADER);
        for (Map.Entry<String, Integer> entry : mapFruit.entrySet()) {
            report.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(DELIMITER)
                    .append(entry.getValue());
        }
        return report.toString();
    }
}
