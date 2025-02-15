package core.basesyntax;

import java.util.Map;

public class ReportGenerationImpl implements ReportGenerationMet {
    @Override
    public String reportGeneration(Map<String, Integer> storage) {
        final StringBuilder strBuild = new StringBuilder("fruit,quantity\n");
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            strBuild.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append("\n");
        }
        return strBuild.toString();
    }
}
