package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class CsvReportServiceImpl implements ReportService {
    private static final String SEPARATOR = ",";
    private static final String HEADER = "fruit,quantity";

    @Override
    public String create(Map<String, Integer> storage) {
        StringBuilder result = new StringBuilder();
        result.append(HEADER);
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            result.append(System.lineSeparator()).append(entry.getKey())
                    .append(SEPARATOR).append(entry.getValue().toString());
        }
        return result.toString();
    }
}
