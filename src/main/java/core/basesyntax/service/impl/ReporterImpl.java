package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.Reporter;
import java.util.Map;
import java.util.stream.Collectors;

public class ReporterImpl implements Reporter {
    private static final String REPORT_HEAD = "fruit,quantity" + System.lineSeparator();
    private static final String ELEMENTS_SEPARATOR = ",";

    @Override
    public String doReport(Map<String, Integer> storage) {
        return REPORT_HEAD
                + Storage.fruitStorage.entrySet().stream()
                    .map(e -> e.getKey() + ELEMENTS_SEPARATOR + e.getValue())
                    .collect(Collectors.joining(System.lineSeparator()));
    }
}
