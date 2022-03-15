package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.List;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createOutput(List<Fruit> storage) {
        StringBuilder outputBuilder = new StringBuilder();
        outputBuilder.append("fruit,quantity").append(System.lineSeparator());
        String outputData = storage.stream()
                .map(Fruit::toString)
                .collect(Collectors.joining(System.lineSeparator()));
        outputBuilder.append(outputData);
        return outputBuilder.toString();
    }
}
