package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity";

    @Override
    public String makeReport(List<Fruit> fruits) {
        String balanceString = fruits.stream()
                .map(p -> (p.getName() + "," + p.getQuantity()))
                .collect(Collectors.joining(System.lineSeparator()));
        return HEADER + System.lineSeparator() + balanceString;
    }
}
