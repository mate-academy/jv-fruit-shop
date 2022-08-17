package core.basesyntax.service;

import java.util.Map;

public class GenerateReportImpl implements GenerateReport {
    private static final String START_WITH = "fruit,quantity";
    private static final String SEPARATE = ",";

    @Override
    public String report(Map<String, Integer> storage) {

        StringBuilder report = new StringBuilder();
        report.append(START_WITH);
        for (Map.Entry<String, Integer> entryMap: storage.entrySet()) {
            report.append(System.lineSeparator())
                    .append(entryMap.getKey())
                    .append(SEPARATE)
                    .append(entryMap.getValue().toString());
        }
        return report.toString();
    }
}
