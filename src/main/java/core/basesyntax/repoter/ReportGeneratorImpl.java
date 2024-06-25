package core.basesyntax.repoter;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String DEFAULT_DELIMITER = ",";
    private StringBuilder builder;

    public ReportGeneratorImpl() {
        builder = new StringBuilder();
    }

    @Override
    public String getReport(Map<String, Integer> repository) {
        builder.append(HEADER)
                .append(System.lineSeparator());
        repository.entrySet().stream()
                .forEach(entry -> builder.append(entry.getKey())
                        .append(DEFAULT_DELIMITER)
                        .append(entry.getValue())
                        .append(System.lineSeparator()));
        builder.setLength(builder.length() - System.lineSeparator().length());
        return builder.toString();
    }
}
