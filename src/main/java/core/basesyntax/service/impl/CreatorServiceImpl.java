package core.basesyntax.service.impl;

import core.basesyntax.service.CreatorService;
import java.util.Map;

public class CreatorServiceImpl implements CreatorService {
    private static final String FIRST_LINE_IN_REPORT = "fruit,quantity";

    @Override
    public String createReport(Map<String, Integer> fruitsTransactionMap) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(FIRST_LINE_IN_REPORT).append(System.lineSeparator());
        fruitsTransactionMap.forEach((k, v) -> stringBuilder.append(k).append(",")
                .append(v).append(System.lineSeparator()));
        return stringBuilder.toString();
    }
}
