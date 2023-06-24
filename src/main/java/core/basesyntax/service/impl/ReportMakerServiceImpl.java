package core.basesyntax.service.impl;

import core.basesyntax.service.ReportMakerService;
import java.util.Map;

public class ReportMakerServiceImpl implements ReportMakerService {
    private static final String TABLE_HEADER = "fruit,quantity";
    private static final char COMA = ',';

    @Override
    public String generateReportText(Map<String, Integer> info) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TABLE_HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : info.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(COMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
