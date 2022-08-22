package core.basesyntax.service;

import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String create(Map<String, Integer> storage) {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(HEADER);
        for (Map.Entry<String, Integer> entry: storage.entrySet()) {
            reportBuilder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue().toString());
        }
        return reportBuilder.toString();
    }
}
