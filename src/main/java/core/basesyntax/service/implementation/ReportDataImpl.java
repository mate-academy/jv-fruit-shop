package core.basesyntax.service.implementation;

import core.basesyntax.service.ReportData;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportDataImpl implements ReportData {
    public static final String SPLITTER = ",";

    @Override
    public String report(Map<String, Integer> data) {
        return data.entrySet().stream()
                .map(fruits -> fruits.getKey() + SPLITTER + fruits.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
