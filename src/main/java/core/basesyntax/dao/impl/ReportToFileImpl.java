package core.basesyntax.dao.impl;

import static java.util.stream.Collectors.joining;

import core.basesyntax.dao.ReportToFile;
import java.util.Map;

public class ReportToFileImpl implements ReportToFile {
    private static final String STRING = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String doReport(Map<String, Integer> resultatMap) {
        return STRING + System.lineSeparator()
                + resultatMap.entrySet().stream()
                .filter(e -> e.getKey() != null && e.getValue() != null)
                .map(e -> e.getKey() + SEPARATOR + e.getValue())
                .collect(joining(System.lineSeparator()));
    }
}
