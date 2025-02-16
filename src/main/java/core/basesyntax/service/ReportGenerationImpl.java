package core.basesyntax.service;

import java.util.Map;

public class ReportGenerationImpl implements ReportGenerationMethods {
    private static final String HEADER_FOR_RESULT = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String reportGeneration(Map<String, Integer> storage) {
        final StringBuilder strBuild = new StringBuilder(HEADER_FOR_RESULT);
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            strBuild.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue());
        }
        return strBuild.toString();
    }
}
