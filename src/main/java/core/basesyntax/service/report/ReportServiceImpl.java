package core.basesyntax.service.report;

import java.util.Map;
import java.util.Set;

public class ReportServiceImpl implements ReportService {
    private static final String HEAD_OF_REPORT = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String formReport(Set<Map.Entry<String, Integer>> entrySet) {
        StringBuilder reportBuilder = new StringBuilder(HEAD_OF_REPORT);
        for (Map.Entry<String, Integer> entry : entrySet) {
            reportBuilder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue());
        }
        return reportBuilder.toString();
    }
}
