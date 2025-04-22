package core.basesyntax.service;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    public static final String header = "fruit,quantity";
    public static final String separator = System.lineSeparator();

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder(header)
                .append(separator);
        for (Map.Entry<String, Integer> entry : Storage.getStorage().entrySet()) {
            stringBuilder
                    .append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(separator);
        }
        return stringBuilder.toString();
    }
}
