package core.basesyntax.service.implementation;

import core.basesyntax.service.ReportService;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    public static final String SPLITTER = ",";

    @Override
    public String prepareReport(Set<Map.Entry<String, Integer>> data) {
        return data.stream()
                .map(fruits -> fruits.getKey() + SPLITTER + fruits.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
