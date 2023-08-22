package core.basesyntax.service.report;

import java.util.Map;

public class ReportGenerateImpl implements ReportGenerate {
    private static final String SEPARATOR = ",";
    private static final String HEAD_LINE = "fruit,quantity";

    @Override
    public String generateReport(Map<String, Integer> storageFruit) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEAD_LINE).append(System.lineSeparator());
        for (Map.Entry<String, Integer> line : storageFruit.entrySet()) {
            stringBuilder.append(line.getKey())
                        .append(SEPARATOR).append(line.getValue())
                        .append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
