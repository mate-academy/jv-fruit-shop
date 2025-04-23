package core.basesyntax.service;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    public static final String header = "fruit,quantity";
    public static final String lineSeparator = System.lineSeparator();
    public static final String commaSeparator = ",";

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder(header)
                .append(lineSeparator);
        for (Map.Entry<String, Integer> entry : Storage.getStorage().entrySet()) {
            stringBuilder
                    .append(entry.getKey())
                    .append(commaSeparator)
                    .append(entry.getValue())
                    .append(lineSeparator);
        }
        return stringBuilder.toString();
    }
}
