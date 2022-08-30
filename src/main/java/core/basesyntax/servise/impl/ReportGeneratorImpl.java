package core.basesyntax.servise.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.servise.ReportGenerator;

import java.util.Map;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String generateReport(Map<Fruit, Integer> storage) {
       return storage.entrySet().stream()
                .map(n -> new StringBuilder("fruit,quantity\n")
                        .append(n.getValue().toString())
                        .append(",").append(n.getKey())
                        .append("\n").toString())
                .collect(Collectors.joining());
    }
}
