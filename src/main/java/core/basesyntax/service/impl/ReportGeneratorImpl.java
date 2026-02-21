package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String REPORT_SEPARATOR = ",";

    @Override
    public String getReport(Map<String, Integer> storage) {
        StringBuilder builder = new StringBuilder(HEADER);
        List<String> fruits = new ArrayList<>(storage.keySet());
        fruits.sort(String::compareTo);
        for (String fruit : fruits) {
            builder.append(System.lineSeparator())
                    .append(fruit)
                    .append(REPORT_SEPARATOR)
                    .append(storage.get(fruit));
        }
        return builder.toString();
    }
}
