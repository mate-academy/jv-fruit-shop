package core.basesyntax.service.impl;

import core.basesyntax.service.ReporterService;

import java.util.Map;
import java.util.stream.Collectors;

public class ReporterServiceImpl implements ReporterService {
    @Override
    public String createReport(Map<String, Integer> data) {
        StringBuilder builder = new StringBuilder();
        return builder.append("fruit, quantity")
                .append(System.lineSeparator())
                .append(data.entrySet().stream()
                    .map(s -> s.getKey() + "," + s.getValue())
                    .collect(Collectors.joining(System.lineSeparator())))
                .toString();
    }
}
