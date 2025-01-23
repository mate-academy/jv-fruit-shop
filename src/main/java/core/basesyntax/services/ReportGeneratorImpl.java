package core.basesyntax.services;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = System.lineSeparator();
    private static final String COMMA = ",";

    @Override
    public String generate(Map<String, Integer> data) {
        StringBuilder report = new StringBuilder();
        report.append(HEADER).append(SEPARATOR);
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            report.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(SEPARATOR);
        }
        return report.toString();
    }
}
