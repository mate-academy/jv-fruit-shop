package core.basesyntax.service.impl;

import core.basesyntax.service.ReportCreatorService;
import java.util.Map;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String FIRST_LINE_IN_REPORT = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String createReport(Map<String, Integer> fruitsTransactionMap) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(FIRST_LINE_IN_REPORT).append(System.lineSeparator());
        fruitsTransactionMap.forEach((k, v) -> stringBuilder.append(k).append(SEPARATOR)
                .append(v).append(System.lineSeparator()));
        return stringBuilder.toString();
    }
}
