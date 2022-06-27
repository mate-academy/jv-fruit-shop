package core.basesyntax.service.impl;

import core.basesyntax.service.Reporter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CsvReporter implements Reporter {
    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public List<String> generate(Map<String, Integer> finalState) {
        List<String> report = new ArrayList<>();
        report.add(HEADER);
        finalState.entrySet().stream()
                .map(e -> e.getKey() + SEPARATOR + e.getValue())
                .forEach(report::add);
        return report;
    }
}
