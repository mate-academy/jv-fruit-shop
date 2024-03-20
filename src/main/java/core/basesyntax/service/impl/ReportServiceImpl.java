package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity";
    private static final String COMMA = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private final Map<String, Integer> fruitsMap;

    public ReportServiceImpl(Map<String, Integer> fruitsMap) {
        this.fruitsMap = fruitsMap;
    }

    @Override
    public String generateReport() {
        StringBuilder reportBuilder = new StringBuilder(HEADER + LINE_SEPARATOR);
        for (Map.Entry<String, Integer> fruit : fruitsMap.entrySet()) {
            reportBuilder.append(fruit.getKey())
                    .append(COMMA)
                    .append(fruit.getValue())
                    .append(LINE_SEPARATOR);
        }
        return reportBuilder.toString();
    }
}
