package core.basesyntax;

import java.util.Map;

public class ReportGenerationImpl implements ReportGenerationMet {
    private final String headerForResult = "fruit,quantity";
    private final String comma = ",";

    @Override
    public String reportGeneration(Map<String, Integer> storage) {
        final StringBuilder strBuild = new StringBuilder(headerForResult);
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            strBuild.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(comma)
                    .append(entry.getValue());
        }
        return strBuild.toString();
    }
}
