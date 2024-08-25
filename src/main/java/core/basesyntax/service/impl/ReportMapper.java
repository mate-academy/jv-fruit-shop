package core.basesyntax.service.impl;

import core.basesyntax.model.Report;
import core.basesyntax.service.Mapper;

import java.util.stream.Collectors;

public class ReportMapper implements Mapper<String, Report> {
    private static final String DELIMITER = ",";
    private static final String HEADER = "fruit,quantity";

    @Override
    public String toObject(Report source) {
        String reportString = source.getFruitQuantityMap().entrySet().stream()
                .map(entry -> entry.getKey() + DELIMITER + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
        return HEADER + System.lineSeparator() + reportString;
    }
}
