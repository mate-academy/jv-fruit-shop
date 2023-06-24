package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String generate(Map<String, Integer> fruits) {

        StringBuilder reportGenerator = new StringBuilder(HEADER + System.lineSeparator());
        for (Map.Entry<String, Integer> entry : fruits.entrySet()) {
            reportGenerator
                    .append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return reportGenerator.toString();
    }
}
