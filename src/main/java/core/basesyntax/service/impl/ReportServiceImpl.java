package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String COMA_SEPARATOR = ",";

    @Override
    public String createReport(Map<String, Integer> storage) {
        return storage.entrySet().stream()
                .map(f -> f.getKey() + COMA_SEPARATOR + f.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
