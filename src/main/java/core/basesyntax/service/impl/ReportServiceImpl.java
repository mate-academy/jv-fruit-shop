package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER_FRUIT = "fruit ";
    private static final String HEADER_QUANTITY = "quantity ";
    private static final String APPENDER = ",";

    @Override
    public String getReport(Map<Fruit, Integer> storage) {
        return HEADER_FRUIT
                + HEADER_QUANTITY
                + System.lineSeparator()
                + storage.entrySet().stream()
                .map(s -> s.getKey().getName() + "," + s.getValue() + System.lineSeparator())
                .collect(Collectors.joining());
    }
}
