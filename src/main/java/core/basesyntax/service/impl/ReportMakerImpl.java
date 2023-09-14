package core.basesyntax.service.impl;

import static java.util.stream.Collectors.summingInt;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportMaker;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReportMakerImpl implements ReportMaker {
    private static final String HEAD_OF_REPORT = "fruit,quantity";

    @Override
    public String makeReport(List<Fruit> fruits) {
        Map<String, Integer> totalAmount = calculateTotalAmount(fruits);
        StringBuilder reportBuilder = new StringBuilder(HEAD_OF_REPORT);
        for (Map.Entry<String, Integer> entry : totalAmount.entrySet()) {
            reportBuilder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(",")
                    .append(entry.getValue());
        }
        return reportBuilder.toString();
    }

    private Map<String, Integer> calculateTotalAmount(List<Fruit> fruits) {
        return fruits.stream()
                .map(Fruit::getName)
                .collect(Collectors.groupingBy(Function.identity(), summingInt(x -> 1)));
    }
}
