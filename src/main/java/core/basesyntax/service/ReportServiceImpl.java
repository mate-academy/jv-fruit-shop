package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity";

    @Override
    public String makeReport(List<Fruit> fruits) {
        String fruitsInfo = fruits.stream()
                .map(f -> (f.getName() + "," + f.getQuantity()))
                .collect(Collectors.joining(System.lineSeparator()));
        return HEADER + System.lineSeparator() + fruitsInfo;
    }
}
